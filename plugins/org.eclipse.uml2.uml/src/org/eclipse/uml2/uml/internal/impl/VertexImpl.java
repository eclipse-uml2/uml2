/*
 * Copyright (c) 2005, 2018 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey - 286329, 323181, 535301
 *   Kenn Hussey (CEA) - 327039, 351774, 418466, 451350, 485756
 *
 */
package org.eclipse.uml2.uml.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.RedefinableElementOperations;
import org.eclipse.uml2.uml.internal.operations.VertexOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getRedefinedElements <em>Redefined Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getRedefinitionContexts <em>Redefinition Context</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#isLeaf <em>Is Leaf</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getIncomings <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getOutgoings <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.VertexImpl#getRedefinedVertex <em>Redefined Vertex</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VertexImpl extends NamedElementImpl implements Vertex {

  /**
   * The default value of the '{@link #isLeaf() <em>Is Leaf</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLeaf()
   * @generated
   * @ordered
   */
  protected static final boolean IS_LEAF_EDEFAULT = false;
  /**
   * The flag representing the value of the '{@link #isLeaf() <em>Is Leaf</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLeaf()
   * @generated
   * @ordered
   */
  protected static final int IS_LEAF_EFLAG = 1 << 12;
  /**
   * The cached value of the '{@link #getRedefinedVertex() <em>Redefined Vertex</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinedVertex()
   * @generated
   * @ordered
   */
  protected Vertex redefinedVertex;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VertexImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return UMLPackage.Literals.VERTEX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RedefinableElement> getRedefinedElements() {
    CacheAdapter cache = getCacheAdapter();
    if (cache != null) {
      Resource eResource = eResource();
      @SuppressWarnings("unchecked")
      EList<RedefinableElement> redefinedElements = (EList<RedefinableElement>) cache.get(eResource, this,
          UMLPackage.Literals.REDEFINABLE_ELEMENT__REDEFINED_ELEMENT);
      if (redefinedElements == null) {
        cache.put(eResource, this, UMLPackage.Literals.REDEFINABLE_ELEMENT__REDEFINED_ELEMENT,
            redefinedElements = new DerivedUnionEObjectEList<RedefinableElement>(RedefinableElement.class, this,
                UMLPackage.VERTEX__REDEFINED_ELEMENT, REDEFINED_ELEMENT_ESUBSETS));
      }
      return redefinedElements;
    }
    return new DerivedUnionEObjectEList<RedefinableElement>(RedefinableElement.class, this,
        UMLPackage.VERTEX__REDEFINED_ELEMENT, REDEFINED_ELEMENT_ESUBSETS);
  }

  /**
   * The array of subset feature identifiers for the '{@link #getRedefinedElements() <em>Redefined Element</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinedElements()
   * @generated
   * @ordered
   */
  protected static final int[] REDEFINED_ELEMENT_ESUBSETS = new int[] { UMLPackage.VERTEX__REDEFINED_VERTEX };

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableElement getRedefinedElement(String name) {
    return getRedefinedElement(name, false, null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinableElement getRedefinedElement(String name, boolean ignoreCase, EClass eClass) {
    redefinedElementLoop: for (RedefinableElement redefinedElement : getRedefinedElements()) {
      if (eClass != null && !eClass.isInstance(redefinedElement))
        continue redefinedElementLoop;
      if (name != null && !(ignoreCase ? name.equalsIgnoreCase(redefinedElement.getName())
          : name.equals(redefinedElement.getName())))
        continue redefinedElementLoop;
      return redefinedElement;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Classifier> getRedefinitionContexts() {
    // TODO: implement this method to return the 'Redefinition Context' reference list
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getRedefinitionContext(String name) {
    return getRedefinitionContext(name, false, null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getRedefinitionContext(String name, boolean ignoreCase, EClass eClass) {
    redefinitionContextLoop: for (Classifier redefinitionContext : getRedefinitionContexts()) {
      if (eClass != null && !eClass.isInstance(redefinitionContext))
        continue redefinitionContextLoop;
      if (name != null && !(ignoreCase ? name.equalsIgnoreCase(redefinitionContext.getName())
          : name.equals(redefinitionContext.getName())))
        continue redefinitionContextLoop;
      return redefinitionContext;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRedefinitionContexts() {
    return !getRedefinitionContexts().isEmpty();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLeaf() {
    return (eFlags & IS_LEAF_EFLAG) != 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsLeaf(boolean newIsLeaf) {
    boolean oldIsLeaf = (eFlags & IS_LEAF_EFLAG) != 0;
    if (newIsLeaf)
      eFlags |= IS_LEAF_EFLAG;
    else
      eFlags &= ~IS_LEAF_EFLAG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UMLPackage.VERTEX__IS_LEAF, oldIsLeaf, newIsLeaf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Namespace getNamespace() {
    Namespace namespace = basicGetNamespace();
    return namespace != null && namespace.eIsProxy() ? (Namespace) eResolveProxy((InternalEObject) namespace)
        : namespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transition> getOutgoings() {
    return VertexOperations.getOutgoings(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition getOutgoing(String name) {
    return getOutgoing(name, false, null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition getOutgoing(String name, boolean ignoreCase, EClass eClass) {
    outgoingLoop: for (Transition outgoing : getOutgoings()) {
      if (eClass != null && !eClass.isInstance(outgoing))
        continue outgoingLoop;
      if (name != null && !(ignoreCase ? name.equalsIgnoreCase(outgoing.getName()) : name.equals(outgoing.getName())))
        continue outgoingLoop;
      return outgoing;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vertex getRedefinedVertex() {
    if (redefinedVertex != null && redefinedVertex.eIsProxy()) {
      InternalEObject oldRedefinedVertex = (InternalEObject) redefinedVertex;
      redefinedVertex = (Vertex) eResolveProxy(oldRedefinedVertex);
      if (redefinedVertex != oldRedefinedVertex) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLPackage.VERTEX__REDEFINED_VERTEX,
              oldRedefinedVertex, redefinedVertex));
      }
    }
    return redefinedVertex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vertex basicGetRedefinedVertex() {
    return redefinedVertex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinedVertex(Vertex newRedefinedVertex) {
    Vertex oldRedefinedVertex = redefinedVertex;
    redefinedVertex = newRedefinedVertex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UMLPackage.VERTEX__REDEFINED_VERTEX, oldRedefinedVertex,
          redefinedVertex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateRedefinitionConsistent(DiagnosticChain diagnostics, Map<Object, Object> context) {
    return RedefinableElementOperations.validateRedefinitionConsistent(this, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateNonLeafRedefinition(DiagnosticChain diagnostics, Map<Object, Object> context) {
    return RedefinableElementOperations.validateNonLeafRedefinition(this, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateRedefinitionContextValid(DiagnosticChain diagnostics, Map<Object, Object> context) {
    return RedefinableElementOperations.validateRedefinitionContextValid(this, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isConsistentWith(RedefinableElement redefiningElement) {
    return VertexOperations.isConsistentWith(this, redefiningElement);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRedefinitionContextValid(RedefinableElement redefinedElement) {
    return RedefinableElementOperations.isRedefinitionContextValid(this, redefinedElement);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transition> getIncomings() {
    return VertexOperations.getIncomings(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition getIncoming(String name) {
    return getIncoming(name, false, null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition getIncoming(String name, boolean ignoreCase, EClass eClass) {
    incomingLoop: for (Transition incoming : getIncomings()) {
      if (eClass != null && !eClass.isInstance(incoming))
        continue incomingLoop;
      if (name != null && !(ignoreCase ? name.equalsIgnoreCase(incoming.getName()) : name.equals(incoming.getName())))
        continue incomingLoop;
      return incoming;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Region getContainer() {
    if (eContainerFeatureID() != UMLPackage.VERTEX__CONTAINER)
      return null;
    return (Region) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Region basicGetContainer() {
    if (eContainerFeatureID() != UMLPackage.VERTEX__CONTAINER)
      return null;
    return (Region) eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(Region newContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newContainer, UMLPackage.VERTEX__CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainer(Region newContainer) {
    if (newContainer != eInternalContainer()
        || (eContainerFeatureID() != UMLPackage.VERTEX__CONTAINER && newContainer != null)) {
      if (EcoreUtil.isAncestor(this, newContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContainer != null)
        msgs = ((InternalEObject) newContainer).eInverseAdd(this, UMLPackage.REGION__SUBVERTEX, Region.class, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UMLPackage.VERTEX__CONTAINER, newContainer, newContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachine containingStateMachine() {
    return VertexOperations.containingStateMachine(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isContainedInState(State s) {
    return VertexOperations.isContainedInState(this, s);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isContainedInRegion(Region r) {
    return VertexOperations.isContainedInRegion(this, r);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case UMLPackage.VERTEX__EANNOTATIONS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getEAnnotations()).basicAdd(otherEnd, msgs);
    case UMLPackage.VERTEX__CONTAINER:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetContainer((Region) otherEnd, msgs);
    }
    return eDynamicInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case UMLPackage.VERTEX__EANNOTATIONS:
      return ((InternalEList<?>) getEAnnotations()).basicRemove(otherEnd, msgs);
    case UMLPackage.VERTEX__OWNED_COMMENT:
      return ((InternalEList<?>) getOwnedComments()).basicRemove(otherEnd, msgs);
    case UMLPackage.VERTEX__NAME_EXPRESSION:
      return basicSetNameExpression(null, msgs);
    case UMLPackage.VERTEX__CONTAINER:
      return basicSetContainer(null, msgs);
    }
    return eDynamicInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case UMLPackage.VERTEX__CONTAINER:
      return eInternalContainer().eInverseRemove(this, UMLPackage.REGION__SUBVERTEX, Region.class, msgs);
    }
    return eDynamicBasicRemoveFromContainer(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case UMLPackage.VERTEX__EANNOTATIONS:
      return getEAnnotations();
    case UMLPackage.VERTEX__OWNED_COMMENT:
      return getOwnedComments();
    case UMLPackage.VERTEX__OWNED_ELEMENT:
      return getOwnedElements();
    case UMLPackage.VERTEX__OWNER:
      if (resolve)
        return getOwner();
      return basicGetOwner();
    case UMLPackage.VERTEX__CLIENT_DEPENDENCY:
      return getClientDependencies();
    case UMLPackage.VERTEX__NAME:
      return getName();
    case UMLPackage.VERTEX__NAME_EXPRESSION:
      if (resolve)
        return getNameExpression();
      return basicGetNameExpression();
    case UMLPackage.VERTEX__NAMESPACE:
      if (resolve)
        return getNamespace();
      return basicGetNamespace();
    case UMLPackage.VERTEX__QUALIFIED_NAME:
      return getQualifiedName();
    case UMLPackage.VERTEX__VISIBILITY:
      return getVisibility();
    case UMLPackage.VERTEX__IS_LEAF:
      return isLeaf();
    case UMLPackage.VERTEX__REDEFINED_ELEMENT:
      return getRedefinedElements();
    case UMLPackage.VERTEX__REDEFINITION_CONTEXT:
      return getRedefinitionContexts();
    case UMLPackage.VERTEX__CONTAINER:
      if (resolve)
        return getContainer();
      return basicGetContainer();
    case UMLPackage.VERTEX__INCOMING:
      return getIncomings();
    case UMLPackage.VERTEX__OUTGOING:
      return getOutgoings();
    case UMLPackage.VERTEX__REDEFINED_VERTEX:
      if (resolve)
        return getRedefinedVertex();
      return basicGetRedefinedVertex();
    }
    return eDynamicGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case UMLPackage.VERTEX__EANNOTATIONS:
      getEAnnotations().clear();
      getEAnnotations().addAll((Collection<? extends EAnnotation>) newValue);
      return;
    case UMLPackage.VERTEX__OWNED_COMMENT:
      getOwnedComments().clear();
      getOwnedComments().addAll((Collection<? extends Comment>) newValue);
      return;
    case UMLPackage.VERTEX__NAME:
      setName((String) newValue);
      return;
    case UMLPackage.VERTEX__NAME_EXPRESSION:
      setNameExpression((StringExpression) newValue);
      return;
    case UMLPackage.VERTEX__VISIBILITY:
      setVisibility((VisibilityKind) newValue);
      return;
    case UMLPackage.VERTEX__IS_LEAF:
      setIsLeaf((Boolean) newValue);
      return;
    case UMLPackage.VERTEX__CONTAINER:
      setContainer((Region) newValue);
      return;
    case UMLPackage.VERTEX__REDEFINED_VERTEX:
      setRedefinedVertex((Vertex) newValue);
      return;
    }
    eDynamicSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case UMLPackage.VERTEX__EANNOTATIONS:
      getEAnnotations().clear();
      return;
    case UMLPackage.VERTEX__OWNED_COMMENT:
      getOwnedComments().clear();
      return;
    case UMLPackage.VERTEX__NAME:
      unsetName();
      return;
    case UMLPackage.VERTEX__NAME_EXPRESSION:
      setNameExpression((StringExpression) null);
      return;
    case UMLPackage.VERTEX__VISIBILITY:
      unsetVisibility();
      return;
    case UMLPackage.VERTEX__IS_LEAF:
      setIsLeaf(IS_LEAF_EDEFAULT);
      return;
    case UMLPackage.VERTEX__CONTAINER:
      setContainer((Region) null);
      return;
    case UMLPackage.VERTEX__REDEFINED_VERTEX:
      setRedefinedVertex((Vertex) null);
      return;
    }
    eDynamicUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case UMLPackage.VERTEX__EANNOTATIONS:
      return eAnnotations != null && !eAnnotations.isEmpty();
    case UMLPackage.VERTEX__OWNED_COMMENT:
      return ownedComments != null && !ownedComments.isEmpty();
    case UMLPackage.VERTEX__OWNED_ELEMENT:
      return isSetOwnedElements();
    case UMLPackage.VERTEX__OWNER:
      return isSetOwner();
    case UMLPackage.VERTEX__CLIENT_DEPENDENCY:
      return !getClientDependencies().isEmpty();
    case UMLPackage.VERTEX__NAME:
      return isSetName();
    case UMLPackage.VERTEX__NAME_EXPRESSION:
      return nameExpression != null;
    case UMLPackage.VERTEX__NAMESPACE:
      return isSetNamespace();
    case UMLPackage.VERTEX__QUALIFIED_NAME:
      return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null
          : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
    case UMLPackage.VERTEX__VISIBILITY:
      return isSetVisibility();
    case UMLPackage.VERTEX__IS_LEAF:
      return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
    case UMLPackage.VERTEX__REDEFINED_ELEMENT:
      return isSetRedefinedElements();
    case UMLPackage.VERTEX__REDEFINITION_CONTEXT:
      return isSetRedefinitionContexts();
    case UMLPackage.VERTEX__CONTAINER:
      return basicGetContainer() != null;
    case UMLPackage.VERTEX__INCOMING:
      return !getIncomings().isEmpty();
    case UMLPackage.VERTEX__OUTGOING:
      return !getOutgoings().isEmpty();
    case UMLPackage.VERTEX__REDEFINED_VERTEX:
      return redefinedVertex != null;
    }
    return eDynamicIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == RedefinableElement.class) {
      switch (derivedFeatureID) {
      case UMLPackage.VERTEX__IS_LEAF:
        return UMLPackage.REDEFINABLE_ELEMENT__IS_LEAF;
      case UMLPackage.VERTEX__REDEFINED_ELEMENT:
        return UMLPackage.REDEFINABLE_ELEMENT__REDEFINED_ELEMENT;
      case UMLPackage.VERTEX__REDEFINITION_CONTEXT:
        return UMLPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT;
      default:
        return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == RedefinableElement.class) {
      switch (baseFeatureID) {
      case UMLPackage.REDEFINABLE_ELEMENT__IS_LEAF:
        return UMLPackage.VERTEX__IS_LEAF;
      case UMLPackage.REDEFINABLE_ELEMENT__REDEFINED_ELEMENT:
        return UMLPackage.VERTEX__REDEFINED_ELEMENT;
      case UMLPackage.REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT:
        return UMLPackage.VERTEX__REDEFINITION_CONTEXT;
      default:
        return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == RedefinableElement.class) {
      switch (baseOperationID) {
      case UMLPackage.REDEFINABLE_ELEMENT___VALIDATE_REDEFINITION_CONSISTENT__DIAGNOSTICCHAIN_MAP:
        return UMLPackage.VERTEX___VALIDATE_REDEFINITION_CONSISTENT__DIAGNOSTICCHAIN_MAP;
      case UMLPackage.REDEFINABLE_ELEMENT___VALIDATE_NON_LEAF_REDEFINITION__DIAGNOSTICCHAIN_MAP:
        return UMLPackage.VERTEX___VALIDATE_NON_LEAF_REDEFINITION__DIAGNOSTICCHAIN_MAP;
      case UMLPackage.REDEFINABLE_ELEMENT___VALIDATE_REDEFINITION_CONTEXT_VALID__DIAGNOSTICCHAIN_MAP:
        return UMLPackage.VERTEX___VALIDATE_REDEFINITION_CONTEXT_VALID__DIAGNOSTICCHAIN_MAP;
      case UMLPackage.REDEFINABLE_ELEMENT___IS_CONSISTENT_WITH__REDEFINABLEELEMENT:
        return UMLPackage.VERTEX___IS_CONSISTENT_WITH__REDEFINABLEELEMENT;
      case UMLPackage.REDEFINABLE_ELEMENT___IS_REDEFINITION_CONTEXT_VALID__REDEFINABLEELEMENT:
        return UMLPackage.VERTEX___IS_REDEFINITION_CONTEXT_VALID__REDEFINABLEELEMENT;
      default:
        return -1;
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case UMLPackage.VERTEX___GET_EANNOTATION__STRING:
      return getEAnnotation((String) arguments.get(0));
    case UMLPackage.VERTEX___VALIDATE_HAS_OWNER__DIAGNOSTICCHAIN_MAP:
      return validateHasOwner((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP:
      return validateNotOwnSelf((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___ADD_KEYWORD__STRING:
      return addKeyword((String) arguments.get(0));
    case UMLPackage.VERTEX___APPLY_STEREOTYPE__STEREOTYPE:
      return applyStereotype((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___CREATE_EANNOTATION__STRING:
      return createEAnnotation((String) arguments.get(0));
    case UMLPackage.VERTEX___DESTROY:
      destroy();
      return null;
    case UMLPackage.VERTEX___GET_KEYWORDS:
      return getKeywords();
    case UMLPackage.VERTEX___GET_APPLICABLE_STEREOTYPE__STRING:
      return getApplicableStereotype((String) arguments.get(0));
    case UMLPackage.VERTEX___GET_APPLICABLE_STEREOTYPES:
      return getApplicableStereotypes();
    case UMLPackage.VERTEX___GET_APPLIED_STEREOTYPE__STRING:
      return getAppliedStereotype((String) arguments.get(0));
    case UMLPackage.VERTEX___GET_APPLIED_STEREOTYPES:
      return getAppliedStereotypes();
    case UMLPackage.VERTEX___GET_APPLIED_SUBSTEREOTYPE__STEREOTYPE_STRING:
      return getAppliedSubstereotype((Stereotype) arguments.get(0), (String) arguments.get(1));
    case UMLPackage.VERTEX___GET_APPLIED_SUBSTEREOTYPES__STEREOTYPE:
      return getAppliedSubstereotypes((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___GET_MODEL:
      return getModel();
    case UMLPackage.VERTEX___GET_NEAREST_PACKAGE:
      return getNearestPackage();
    case UMLPackage.VERTEX___GET_RELATIONSHIPS:
      return getRelationships();
    case UMLPackage.VERTEX___GET_RELATIONSHIPS__ECLASS:
      return getRelationships((EClass) arguments.get(0));
    case UMLPackage.VERTEX___GET_REQUIRED_STEREOTYPE__STRING:
      return getRequiredStereotype((String) arguments.get(0));
    case UMLPackage.VERTEX___GET_REQUIRED_STEREOTYPES:
      return getRequiredStereotypes();
    case UMLPackage.VERTEX___GET_SOURCE_DIRECTED_RELATIONSHIPS:
      return getSourceDirectedRelationships();
    case UMLPackage.VERTEX___GET_SOURCE_DIRECTED_RELATIONSHIPS__ECLASS:
      return getSourceDirectedRelationships((EClass) arguments.get(0));
    case UMLPackage.VERTEX___GET_STEREOTYPE_APPLICATION__STEREOTYPE:
      return getStereotypeApplication((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___GET_STEREOTYPE_APPLICATIONS:
      return getStereotypeApplications();
    case UMLPackage.VERTEX___GET_TARGET_DIRECTED_RELATIONSHIPS:
      return getTargetDirectedRelationships();
    case UMLPackage.VERTEX___GET_TARGET_DIRECTED_RELATIONSHIPS__ECLASS:
      return getTargetDirectedRelationships((EClass) arguments.get(0));
    case UMLPackage.VERTEX___GET_VALUE__STEREOTYPE_STRING:
      return getValue((Stereotype) arguments.get(0), (String) arguments.get(1));
    case UMLPackage.VERTEX___HAS_KEYWORD__STRING:
      return hasKeyword((String) arguments.get(0));
    case UMLPackage.VERTEX___HAS_VALUE__STEREOTYPE_STRING:
      return hasValue((Stereotype) arguments.get(0), (String) arguments.get(1));
    case UMLPackage.VERTEX___IS_STEREOTYPE_APPLICABLE__STEREOTYPE:
      return isStereotypeApplicable((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___IS_STEREOTYPE_APPLIED__STEREOTYPE:
      return isStereotypeApplied((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___IS_STEREOTYPE_REQUIRED__STEREOTYPE:
      return isStereotypeRequired((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___REMOVE_KEYWORD__STRING:
      return removeKeyword((String) arguments.get(0));
    case UMLPackage.VERTEX___SET_VALUE__STEREOTYPE_STRING_OBJECT:
      setValue((Stereotype) arguments.get(0), (String) arguments.get(1), arguments.get(2));
      return null;
    case UMLPackage.VERTEX___UNAPPLY_STEREOTYPE__STEREOTYPE:
      return unapplyStereotype((Stereotype) arguments.get(0));
    case UMLPackage.VERTEX___ALL_OWNED_ELEMENTS:
      return allOwnedElements();
    case UMLPackage.VERTEX___MUST_BE_OWNED:
      return mustBeOwned();
    case UMLPackage.VERTEX___VALIDATE_VISIBILITY_NEEDS_OWNERSHIP__DIAGNOSTICCHAIN_MAP:
      return validateVisibilityNeedsOwnership((DiagnosticChain) arguments.get(0),
          (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___VALIDATE_HAS_QUALIFIED_NAME__DIAGNOSTICCHAIN_MAP:
      return validateHasQualifiedName((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___VALIDATE_HAS_NO_QUALIFIED_NAME__DIAGNOSTICCHAIN_MAP:
      return validateHasNoQualifiedName((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___CREATE_DEPENDENCY__NAMEDELEMENT:
      return createDependency((NamedElement) arguments.get(0));
    case UMLPackage.VERTEX___CREATE_USAGE__NAMEDELEMENT:
      return createUsage((NamedElement) arguments.get(0));
    case UMLPackage.VERTEX___GET_LABEL:
      return getLabel();
    case UMLPackage.VERTEX___GET_LABEL__BOOLEAN:
      return getLabel((Boolean) arguments.get(0));
    case UMLPackage.VERTEX___GET_NAMESPACE:
      return getNamespace();
    case UMLPackage.VERTEX___ALL_NAMESPACES:
      return allNamespaces();
    case UMLPackage.VERTEX___ALL_OWNING_PACKAGES:
      return allOwningPackages();
    case UMLPackage.VERTEX___IS_DISTINGUISHABLE_FROM__NAMEDELEMENT_NAMESPACE:
      return isDistinguishableFrom((NamedElement) arguments.get(0), (Namespace) arguments.get(1));
    case UMLPackage.VERTEX___GET_QUALIFIED_NAME:
      return getQualifiedName();
    case UMLPackage.VERTEX___SEPARATOR:
      return separator();
    case UMLPackage.VERTEX___GET_CLIENT_DEPENDENCIES:
      return getClientDependencies();
    case UMLPackage.VERTEX___VALIDATE_REDEFINITION_CONSISTENT__DIAGNOSTICCHAIN_MAP:
      return validateRedefinitionConsistent((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___VALIDATE_NON_LEAF_REDEFINITION__DIAGNOSTICCHAIN_MAP:
      return validateNonLeafRedefinition((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___VALIDATE_REDEFINITION_CONTEXT_VALID__DIAGNOSTICCHAIN_MAP:
      return validateRedefinitionContextValid((DiagnosticChain) arguments.get(0),
          (Map<Object, Object>) arguments.get(1));
    case UMLPackage.VERTEX___IS_CONSISTENT_WITH__REDEFINABLEELEMENT:
      return isConsistentWith((RedefinableElement) arguments.get(0));
    case UMLPackage.VERTEX___IS_REDEFINITION_CONTEXT_VALID__REDEFINABLEELEMENT:
      return isRedefinitionContextValid((RedefinableElement) arguments.get(0));
    case UMLPackage.VERTEX___CONTAINING_STATE_MACHINE:
      return containingStateMachine();
    case UMLPackage.VERTEX___GET_INCOMINGS:
      return getIncomings();
    case UMLPackage.VERTEX___GET_OUTGOINGS:
      return getOutgoings();
    case UMLPackage.VERTEX___IS_CONTAINED_IN_STATE__STATE:
      return isContainedInState((State) arguments.get(0));
    case UMLPackage.VERTEX___IS_CONTAINED_IN_REGION__REGION:
      return isContainedInRegion((Region) arguments.get(0));
    }
    return eDynamicInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (isLeaf: "); //$NON-NLS-1$
    result.append((eFlags & IS_LEAF_EFLAG) != 0);
    result.append(')');
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetRedefinedElements() {
    return eIsSet(UMLPackage.VERTEX__REDEFINED_VERTEX);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Namespace basicGetNamespace() {
    Region container = basicGetContainer();
    if (container != null) {
      return container;
    }
    return super.basicGetNamespace();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetNamespace() {
    return super.isSetNamespace() || eIsSet(UMLPackage.VERTEX__CONTAINER);
  }

} //VertexImpl
