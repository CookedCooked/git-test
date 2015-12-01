package com.newding;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Note that a WebApplicationInitializer is only needed if you are building a
 * war file and deploying it. If you prefer to run an embedded container (we do)
 * then you won't need this at all.
 */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootMybatisApplication.class);
	}
}
