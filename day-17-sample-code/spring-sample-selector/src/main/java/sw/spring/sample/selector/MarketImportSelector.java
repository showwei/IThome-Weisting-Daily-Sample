package sw.spring.sample.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import sw.spring.sample.services.NorthMarketServiceImpl;
import sw.spring.sample.services.SouthMarketServiceImpl;

public class MarketImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {NorthMarketServiceImpl.class.getName(), SouthMarketServiceImpl.class.getName()};
    }
}
