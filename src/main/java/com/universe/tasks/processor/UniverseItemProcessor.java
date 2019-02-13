package com.universe.tasks.processor;

import com.universe.tasks.model.Universe;
import org.springframework.batch.item.ItemProcessor;

public class UniverseItemProcessor implements ItemProcessor<Universe, Universe> {

    @Override
    public Universe process(Universe universe) throws Exception {
        return universe;
    }
}