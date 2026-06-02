/*
 * Copyright (c) 2025 Data In Motion and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Data In Motion - initial API and implementation
 *
 */
package org.eclipse.uml2.uml.resources.uml251;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * Plugin for UML 2.5.1 resources support.
 *
 * @since 1.0
 */
public class ResourcesUML251Plugin
		extends EMFPlugin {

	/**
	 * The plugin ID.
	 */
	public static final String PLUGIN_ID = "org.eclipse.uml2.uml.resources.uml251";

	/**
	 * The singleton instance of the plugin.
	 */
	public static final ResourcesUML251Plugin INSTANCE = new ResourcesUML251Plugin();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	/**
	 * Creates the singleton instance.
	 */
	private ResourcesUML251Plugin() {
		super(new ResourceLocator[]{});
	}

	/**
	 * Returns the singleton instance of the plugin.
	 *
	 * @return the singleton instance.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * The actual implementation of the <b>Plugin</b>.
	 */
	public static class Implementation
			extends EclipsePlugin {

		public Implementation() {
			super();

			plugin = this;
		}
	}

}
