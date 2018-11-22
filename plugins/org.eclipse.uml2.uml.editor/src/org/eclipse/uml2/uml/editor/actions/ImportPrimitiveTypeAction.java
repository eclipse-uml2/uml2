/*
 * Copyright (c) 2005, 2018 IBM Corporation and others.
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
package org.eclipse.uml2.uml.editor.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.editor.UMLEditorPlugin;

public class ImportPrimitiveTypeAction
		extends ImportTypeAction {

	public ImportPrimitiveTypeAction() {
		super();
	}

	@Override
	protected List<Type> getChoiceOfValues(Package package_) {
		List<Type> choiceOfValues = super.getChoiceOfValues(package_);

		for (Iterator<Type> cov = choiceOfValues.iterator(); cov.hasNext();) {
			Type type = cov.next();

			if (!(type instanceof PrimitiveType)) {
				cov.remove();
			}
		}

		return choiceOfValues;
	}

	@Override
	protected String getActionCommandLabel() {
		return UMLEditorPlugin.INSTANCE
			.getString("_UI_ImportPrimitiveTypeActionCommand_label"); //$NON-NLS-1$
	}

}
