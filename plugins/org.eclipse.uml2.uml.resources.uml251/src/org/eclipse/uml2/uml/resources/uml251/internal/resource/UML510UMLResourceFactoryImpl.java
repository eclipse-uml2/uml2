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
package org.eclipse.uml2.uml.resources.uml251.internal.resource;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.uml251.resource.UML510UMLExtendedMetaData;
import org.eclipse.uml2.uml.resources.uml251.resource.UML510UMLResource;
import org.eclipse.uml2.uml.resources.uml251.resource.UML510UMLResourceHandler;

/**
 * Resource factory that converts .uml models.
 * <ul>
 * <li>OMG: UML 2.5.1</li>
 * <li>API: UML2 5.1</li>
 * </ul>
 *
 * @since 1.0
 */
public class UML510UMLResourceFactoryImpl
		extends UMLResourceFactoryImpl
		implements UML510UMLResource.Factory {

	public UML510UMLResourceFactoryImpl() {
		super();
	}

	@Override
	public Resource createResourceGen(URI uri) {
		UML510UMLResource result = new UML510UMLResourceImpl(uri);
		result.setEncoding(UML510UMLResource.DEFAULT_ENCODING);
		return result;
	}

	@Override
	public Resource createResource(URI uri) {
		UMLResource resource = (UMLResource) super.createResource(uri);

		Map<Object, Object> defaultLoadOptions = resource
			.getDefaultLoadOptions();

		EPackage.Registry ePackageRegistry = new EPackageRegistryImpl(
			EPackage.Registry.INSTANCE);
		ExtendedMetaData extendedMetaData = new UML510UMLExtendedMetaData(
			ePackageRegistry);

		defaultLoadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA,
			extendedMetaData);
		defaultLoadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING,
			Boolean.FALSE);
		defaultLoadOptions.put(XMLResource.OPTION_RESOURCE_HANDLER,
			new UML510UMLResourceHandler());

		return resource;
	}

}
