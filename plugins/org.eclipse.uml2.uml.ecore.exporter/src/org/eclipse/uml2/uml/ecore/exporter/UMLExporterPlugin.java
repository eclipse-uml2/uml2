/*
 * Copyright (c) 2006, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.ecore.exporter;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.exporter.ExporterPlugin;
import org.eclipse.uml2.uml.UMLPlugin;

/**
 * The <b>Plugin</b> for the UML2.UML.Ecore.Exporter library.
 */
public final class UMLExporterPlugin
		extends EMFPlugin {

	/**
	 * The singleton instance of the plugin.
	 */
	public static final UMLExporterPlugin INSTANCE = new UMLExporterPlugin();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	/**
	 * Creates the singleton instance.
	 */
	private UMLExporterPlugin() {
		super(
			new ResourceLocator[]{UMLPlugin.INSTANCE, ExporterPlugin.INSTANCE});
	}

	/*
	 * Javadoc copied from base class.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation
			extends EclipsePlugin {

		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}
}
