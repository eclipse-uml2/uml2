/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: UMLCommandAction.java,v 1.1 2005/12/22 20:21:06 khussey Exp $
 */
package org.eclipse.uml2.uml.editor.actions;

import java.util.Comparator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.action.CommandAction;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.common.edit.provider.IItemQualifiedTextProvider;
import org.eclipse.uml2.uml.editor.presentation.UMLEditor;

public class UMLCommandAction
		extends CommandAction {

	protected class TextComparator
			implements Comparator {

		public int compare(Object o1, Object o2) {
			return getLabelProvider().getText(o1).compareTo(
				getLabelProvider().getText(o2));
		}
	}

	private ILabelProvider labelProvider = null;

	protected UMLCommandAction() {
		super();
	}

	protected ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	protected AdapterFactory getAdapterFactory() {
		return workbenchPart instanceof UMLEditor
			? ((UMLEditor) workbenchPart).getAdapterFactory()
			: null;
	}

	public void setActiveEditor(IAction action, IEditorPart editorPart) {
		super.setActiveEditor(action, editorPart);

		labelProvider = editorPart == null
			? null
			: new AdapterFactoryLabelProvider(getAdapterFactory()) {

				public String getColumnText(Object object, int columnIndex) {
					IItemQualifiedTextProvider itemQualifiedTextProvider = (IItemQualifiedTextProvider) adapterFactory
						.adapt(object, IItemQualifiedTextProvider.class);

					return itemQualifiedTextProvider != null
						? itemQualifiedTextProvider.getQualifiedText(object)
						: super.getColumnText(object, columnIndex);
				}

				public String getText(Object object) {
					IItemQualifiedTextProvider itemQualifiedTextProvider = (IItemQualifiedTextProvider) adapterFactory
						.adapt(object, IItemQualifiedTextProvider.class);

					return itemQualifiedTextProvider != null
						? itemQualifiedTextProvider.getQualifiedText(object)
						: super.getText(object);
				}
			};
	}
}