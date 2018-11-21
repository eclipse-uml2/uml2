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
package org.eclipse.uml2.common.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * @since 1.2
 */
public class SubsetSupersetEObjectContainmentEList<E>
		extends SubsetSupersetEObjectEList<E> {

	private static final long serialVersionUID = 1L;

	public static class Unsettable<E>
			extends SubsetSupersetEObjectContainmentEList<E> {

		private static final long serialVersionUID = 1L;

		public static class Resolving<E>
				extends Unsettable<E> {

			private static final long serialVersionUID = 1L;

			public Resolving(Class<?> dataClass, InternalEObject owner,
					int featureID, int[] supersetFeatureIDs,
					int[] subsetFeatureIDs) {
				super(dataClass, owner, featureID, supersetFeatureIDs,
					subsetFeatureIDs);
			}

			@Override
			protected boolean hasProxies() {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected E resolve(int index, E object) {
				return (E) resolve(index, (EObject) object);
			}
		}

		protected boolean isSet;

		public Unsettable(Class<?> dataClass, InternalEObject owner,
				int featureID, int[] supersetFeatureIDs, int[] subsetFeatureIDs) {
			super(dataClass, owner, featureID, supersetFeatureIDs,
				subsetFeatureIDs);
		}

		@Override
		protected void didChange() {
			isSet = true;
		}

		@Override
		public boolean isSet() {
			return isSet;
		}

		@Override
		public void unset() {
			super.unset();

			if (isNotificationRequired()) {
				boolean oldIsSet = isSet;
				isSet = false;

				owner.eNotify(createNotification(Notification.UNSET, oldIsSet,
					false));
			} else {
				isSet = false;
			}
		}
	}

	public static class Resolving<E>
			extends SubsetSupersetEObjectContainmentEList<E> {

		private static final long serialVersionUID = 1L;

		public Resolving(Class<?> dataClass, InternalEObject owner,
				int featureID, int[] supersetFeatureIDs, int[] subsetFeatureIDs) {
			super(dataClass, owner, featureID, supersetFeatureIDs,
				subsetFeatureIDs);
		}

		@Override
		protected boolean hasProxies() {
			return true;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected E resolve(int index, E object) {
			return (E) resolve(index, (EObject) object);
		}
	}

	public SubsetSupersetEObjectContainmentEList(Class<?> dataClass,
			InternalEObject owner, int featureID, int[] supersetFeatureIDs,
			int[] subsetFeatureIDs) {
		super(dataClass, owner, featureID, supersetFeatureIDs, subsetFeatureIDs);
	}

	@Override
	protected boolean hasInverse() {
		return true;
	}

	@Override
	protected boolean hasNavigableInverse() {
		return false;
	}

	@Override
	protected boolean isContainment() {
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		return super.addAll(new ArrayList<E>(collection));
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		return super.addAll(index, new ArrayList<E>(collection));
	}

}