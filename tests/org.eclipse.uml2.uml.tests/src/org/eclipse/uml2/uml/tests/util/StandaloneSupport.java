/*
 * Copyright (c) 2013, 2018 CEA, Christian W. Damus, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - initial API and implementation
 *   Christian W. Damus (CEA) - 414572, 401682, 420338, 437977
 *   Christian W. Damus - 512520
 *   Kenn Hussey - 526679, 526217, 535301, 540812
 *
 */
package org.eclipse.uml2.uml.tests.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.tests.UMLAllTests;

/**
 * Utility for configuring the test environment for stand-alone execution.
 */
public class StandaloneSupport {

	/**
	 * Not instantiable by clients.
	 */
	private StandaloneSupport() {
		super();
	}

	public static boolean isStandalone() {
		return !EcorePlugin.IS_ECLIPSE_RUNNING;
	}

	public static void initGlobals() {

		if (!isStandalone()) {
			throw new IllegalStateException("not running stand-alone"); //$NON-NLS-1$
		}
		
		UMLResourcesUtil.initGlobalRegistries();
	}

	public static ResourceSet init(ResourceSet rset) {

		if (!isStandalone()) {
			throw new IllegalStateException("not running stand-alone"); //$NON-NLS-1$
		}

		UMLResourcesUtil.init(rset);

		if (rset != null) {
			rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		}

		URI prefix = getBaseUMLTestsURI();

		mapURIs(URIConverter.URI_MAP,
			URI.createURI("pathmap://UML_TEST_MODELS/"), //$NON-NLS-1$
			prefix.appendSegment("models")); //$NON-NLS-1$

		mapURIs(URIConverter.URI_MAP,
			URI.createURI("pathmap://UML_TEST_PROFILES/"), //$NON-NLS-1$
			prefix.appendSegment("profiles")); //$NON-NLS-1$

		return rset;
	}

	/**
	 * Create a test suite that is applicable only if the Eclipse environment is
	 * available.
	 * 
	 * @param name
	 *            the name of the test suite
	 * @param testClass
	 *            the test classes to incorporate into the suite
	 * 
	 * @return a test suite if Eclipse is running, otherwise just a placeholder
	 *         for the skipped tests
	 * 
	 * @since 5.0
	 */
	public static Test eclipseTestSuite(String name, Class<?>... testClass) {
		Test result;

		try {
			if (!isStandalone()) {
				result = suite(name, testClass);
			} else {
				result = new TestSuite(String.format(
					"<%s skipped because Eclipse is not running>", name)); //$NON-NLS-1$
			}
		} catch (LinkageError le) {
			// no (or incomplete) Eclipse environment on the classpath
			result = new TestSuite(String.format(
				"<%s skipped because Eclipse is not running>", name)); //$NON-NLS-1$
		}

		return result;
	}

	/**
	 * Create a test suite that is applicable only in stand-alone execution
	 * (when Eclipse is <em>not</em> running.
	 * 
	 * @param name
	 *            the name of the test suite
	 * @param testClass
	 *            the test classes to incorporate into the suite
	 * 
	 * @return a test suite in stand-alone mode, otherwise just a placeholder
	 *         for the skipped tests
	 * 
	 * @since 5.0
	 */
	public static Test standaloneTestSuite(String name, Class<?>... testClass) {
		Test result;

		if (isStandalone()) {
			result = suite(name, testClass);
		} else {
			result = new TestSuite(String.format(
				"<%s skipped because Eclipse is running>", name)); //$NON-NLS-1$
		}

		return result;
	}

	private static Test suite(String name, Class<?>... testClass) {
		Test result;

		if (testClass.length == 1) {
			// just one test class? It's the suite
			result = suite(testClass[0]);
		} else {
			TestSuite suite = new TestSuite(name);

			for (Class<?> next : testClass) {
				suite.addTest(suite(next));
			}

			result = suite;
		}

		return result;
	}

	private static Test suite(Class<?> testClass) {
		Test result;

		try {
			try {
				Method method = testClass.getDeclaredMethod("suite");
				if (!Modifier.isStatic(method.getModifiers())) {
					throw new NoSuchMethodException("no static suite method"); //$NON-NLS-1$
				}
				result = (Test) method.invoke(null);
			} catch (NoSuchMethodException e) {
				result = new TestSuite(testClass);
			}
		} catch (Exception e) {
			result = new TestSuite(String.format(
				"<Failed to instantiate test %s>", testClass)); //$NON-NLS-1$
		}

		return result;
	}

	private static URI getBaseUMLTestsURI() {
		URL resultURL = UMLAllTests.class.getClassLoader()
			.getResource("models/Bug401804.uml"); //$NON-NLS-1$

		URI result;

		if (resultURL != null) {
			// remove the models/Bug401804.uml segments of the resource we found
			result = URI.createURI(resultURL.toExternalForm(), true)
				.trimSegments(2);
		} else {
			// probably, we're not running with JARs, so assume the source
			// project folder layout
			resultURL = UMLAllTests.class.getResource("UMLAllTests.class"); //$NON-NLS-1$

			String baseURL = resultURL.toExternalForm();

			int index = baseURL.lastIndexOf("/bin/"); //$NON-NLS-1$

			if (index == -1) {
				index = baseURL.lastIndexOf("/target/classes/"); //$NON-NLS-1$
			}

			if (index != -1) {
				baseURL = baseURL.substring(0, index);
			}

			result = URI.createURI(baseURL, true);
		}

		return result;
	}

	private static void mapURIs(Map<URI, URI> uriMap,
			URI prefix, URI location) {

		// ensure trailing separator (make it a "URI prefix")
		if (!prefix.hasTrailingPathSeparator()) {
			prefix = prefix.appendSegment(""); //$NON-NLS-1$
		}

		// same with the location
		if (!location.hasTrailingPathSeparator()) {
			location = location.appendSegment(""); //$NON-NLS-1$
		}

		uriMap.put(prefix, location);
	}
}