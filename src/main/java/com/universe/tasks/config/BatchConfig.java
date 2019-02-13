package com.universe.tasks.config;

import com.universe.tasks.model.Universe;
import com.universe.tasks.processor.UniverseItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean(destroyMethod="")
    public JdbcCursorItemReader<Universe> reader() {
        JdbcCursorItemReader<Universe> cursorItemReader = new JdbcCursorItemReader<>();
        cursorItemReader.setDataSource(dataSource);
        cursorItemReader.setSql("SELECT universe_id, universe_name FROM universe");
        cursorItemReader.setRowMapper(new UniverseRowMapper());
        return cursorItemReader;
    }

    @Bean
    public UniverseItemProcessor processor() {
        return new UniverseItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<Universe> writer() {
        FlatFileItemWriter<Universe> writer = new FlatFileItemWriter<>();
        writer.setResource(new ClassPathResource("persons.csv"));
        writer.setAppendAllowed(true);
        DelimitedLineAggregator<Universe> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");
        BeanWrapperFieldExtractor<Universe> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"universeId","universeName"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(lineAggregator);
        return writer;
    }
    
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Universe, Universe>chunk(10).reader(reader()).processor(processor()).writer(writer()).build();
    }

    @Bean
    public Job exportUniverseJob() {
        return jobBuilderFactory.get("exportUniverseJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
    }
    
}
