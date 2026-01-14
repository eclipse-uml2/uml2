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
package org.eclipse.uml2.uml.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;

/**
 * Extended meta-data required for model migration.
 * OMG:  UML 2.5.1
 * API:  UML2 5.1
 *
 * @since 5.1
 */
public class UML510UMLExtendedMetaData
		extends BasicExtendedMetaData {

	protected static Map<URI, URI> uriMap = null;

	public static Map<URI, URI> getURIMap() {

		if (uriMap == null) {

			synchronized (UML510UMLExtendedMetaData.class) {

				if (uriMap == null) {
					uriMap = new HashMap<URI, URI>();

					// UML 5.1.0 is compatible with 5.0.0, no URI remapping needed
				}
			}
		}

		return uriMap;
	}

	public UML510UMLExtendedMetaData(EPackage.Registry registry) {
		super(registry);
	}

}
