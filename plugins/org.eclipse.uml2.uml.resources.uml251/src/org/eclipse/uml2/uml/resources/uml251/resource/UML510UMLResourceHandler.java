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
package org.eclipse.uml2.uml.resources.uml251.resource;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;

/**
 * Resource handler that converts .uml models.
 * OMG:  UML 2.5.1
 * API:  UML2 5.1
 *
 * @since 1.0
 */
public class UML510UMLResourceHandler
		extends BasicResourceHandler {

	protected String xmiVersion = null;

	@Override
	public void preLoad(XMLResource resource, InputStream inputStream,
			Map<?, ?> options) {
		xmiVersion = ((XMIResource) resource).getXMIVersion();
	}

	@Override
	public void postLoad(final XMLResource resource, InputStream inputStream,
			Map<?, ?> options) {
		((XMIResource) resource).setXMIVersion(xmiVersion);
	}

}
