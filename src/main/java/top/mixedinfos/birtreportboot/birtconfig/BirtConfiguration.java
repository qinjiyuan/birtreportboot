package top.mixedinfos.birtreportboot.birtconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import java.util.logging.Level;

public class BirtConfiguration {

    @Bean
    protected BirtEngineFactory  engine(){
        BirtEngineFactory birtEngineFactory = new BirtEngineFactory();
        birtEngineFactory.setLogLevel( Level.INFO);
        birtEngineFactory.setLogDirectory( new FileSystemResource("D://logs/"));
        return birtEngineFactory ;
    }
}
