package com.japhet.store.book;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;

@ApplicationScoped
class BookApplicationLifeCycle {

	@Inject
	Logger LOGGER;

	void onStart(@Observes StartupEvent ev) {
		LOGGER.info("______             _");
		LOGGER.info("| ___ \\           | |");
		LOGGER.info("| |_/ / ___   ___ | | __");
		LOGGER.info("| ___ \\/ _ \\ / _ \\| |/ /");
		LOGGER.info("| |_/ / (_) | (_) |   <");
		LOGGER.info("\\____/ \\___/ \\___/|_|\\_\\");
		LOGGER.info("                         Powered by Quarkus");
		LOGGER.info(
				"The application Book is starting with profile "
						+ ProfileManager.getActiveProfile()
		);
	}

	void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("The application Book is stopping...");
	}
}
