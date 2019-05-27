/*
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.xtext.tdl.TdlRuntimeModule
import org.xtext.tdl.TdlStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class TdlIdeSetup extends TdlStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new TdlRuntimeModule, new TdlIdeModule))
	}
	
}