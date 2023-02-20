//package com.gusta.springbatch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.function.FunctionItemProcessor;
//import org.springframework.batch.item.support.IteratorItemReader;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import java.util.stream.IntStream;
//
//@Configuration
//public class ParImparBatchConfig {
//
//    @Bean
//    public Job jobParImpar(JobRepository jobRepository, Step step) {
//        return new JobBuilder("parImparJob", jobRepository)
//                .start(step)
//                .incrementer(new RunIdIncrementer())
//                .build();
//    }
//
//    @Bean
//    public Step stepParImpar(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("parImparStep", jobRepository)
//                .<Integer, String>chunk(1, transactionManager)
//                .reader(contaAteDezReader())
//                .processor(parOuImparProcessor())
//                .writer(imprimeParOuImparWriter())
//                .build();
//    }
//
//    public IteratorItemReader<Integer> contaAteDezReader() {
//        return new IteratorItemReader<>(IntStream.range(1, 11).iterator());
//    }
//
//    public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
//        return new FunctionItemProcessor<>(item -> item % 2 == 0
//                ? String.format("Item %s é Par", item)
//                : String.format("Item %s é Impar", item));
//    }
//
//    public ItemWriter<String> imprimeParOuImparWriter() {
//        return itens -> itens.forEach(System.out::println);
//    }
//}
