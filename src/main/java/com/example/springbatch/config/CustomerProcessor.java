package com.example.springbatch.config;

import com.example.springbatch.entity.Recovery;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Recovery, Recovery> {

    @Override
    public Recovery process(Recovery recovery) throws Exception {
        return recovery;
    }
}
