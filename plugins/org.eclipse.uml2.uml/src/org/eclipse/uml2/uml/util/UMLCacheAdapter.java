/*
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: UMLCacheAdapter.java,v 1.1.2.1 2007/06/12 15:38:24 khussey Exp $
 */
package org.eclipse.uml2.uml.util;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLCacheAdapter
		extends CacheAdapter {

	protected boolean isIncluded(EReference eReference) {
		return eReference == UMLPackage.Literals.TRANSITION__SOURCE
			|| eReference == UMLPackage.Literals.TRANSITION__TARGET
			|| eReference == UMLPackage.Literals.CONNECTOR_END__ROLE
			|| super.isIncluded(eReference);
	}

}
