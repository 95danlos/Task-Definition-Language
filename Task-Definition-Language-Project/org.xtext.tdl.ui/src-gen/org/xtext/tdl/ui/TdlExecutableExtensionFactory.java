/*
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.xtext.tdl.ui.internal.TdlActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TdlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return TdlActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return TdlActivator.getInstance().getInjector(TdlActivator.ORG_XTEXT_TDL_TDL);
	}
	
}