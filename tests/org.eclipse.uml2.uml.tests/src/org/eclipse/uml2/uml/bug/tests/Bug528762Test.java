/*
 * Copyright (c) 2018 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Sebastien Revol (CEA) - initial API and implementation
 *   Kenn Hussey - 528762
 *
 */
package org.eclipse.uml2.uml.bug.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Bug528762Test
		extends TestCase {

	public Bug528762Test() {
		super();
	}

	public static Test suite() {
		return new TestSuite(Bug512520Test.class, "Bug 528762 tests"); //$NON-NLS-1$
	}


	public void testBinarySerialization() {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("modelName"); //$NON-NLS-1$
		String activityName = "activity"; //$NON-NLS-1$

		Activity activity = (Activity) model.createOwnedType(activityName,
			UMLPackage.eINSTANCE.getActivity());

		for (int i = 0; i < 10; i++) {
			activity.createOwnedNode("action" + i, //$NON-NLS-1$
				UMLPackage.eINSTANCE.getOpaqueAction());
		}
		assertEquals(10, activity.getOwnedNodes().size());
		assertEquals(10, activity.getNodes().size());

		try {
			URI tmpURI = URI.createFileURI("Bug528762.uml"); //$NON-NLS-1$
			ResourceSet resSet = new ResourceSetImpl();
			Resource outputResource = resSet.createResource(tmpURI);
			outputResource.getContents().add(model);

			Map<Object, Object> options = new HashMap<Object, Object>();

			options.put(XMIResource.OPTION_BINARY, Boolean.TRUE);
			outputResource.save(options);

			resSet = new ResourceSetImpl();

			outputResource.unload();
			outputResource.eAdapters().clear();

			resSet.getResources().clear();
			resSet.eAdapters().clear();

			outputResource = resSet.createResource(tmpURI);

			outputResource.unload();
			outputResource.eAdapters().clear();

			resSet.getResources().clear();
			resSet.eAdapters().clear();

			outputResource.unload();

			outputResource.load(options);

			model = (Model) outputResource.getContents().get(0);
			activity = (Activity) model.getPackagedElement(activityName, false,
				UMLPackage.eINSTANCE.getActivity(), false);
			assertEquals(10, activity.getOwnedNodes().size());
			assertEquals(10, activity.getNodes().size());

		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail();
		}
	}

}
