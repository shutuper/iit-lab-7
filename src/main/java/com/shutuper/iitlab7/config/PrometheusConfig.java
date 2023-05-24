package com.shutuper.iitlab7.config;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusConfig {

	@Bean
	public PrometheusMeterRegistry prometheusMeterRegistry() {
		PrometheusMeterRegistry meterRegistry = new PrometheusMeterRegistry(
				io.micrometer.prometheus.PrometheusConfig.DEFAULT, CollectorRegistry.defaultRegistry, Clock.SYSTEM
		);

		new ClassLoaderMetrics().bindTo(meterRegistry);
		new JvmMemoryMetrics().bindTo(meterRegistry);
		new JvmGcMetrics().bindTo(meterRegistry);
		new ProcessorMetrics().bindTo(meterRegistry);
		new JvmThreadMetrics().bindTo(meterRegistry);

		return meterRegistry;
	}

}
