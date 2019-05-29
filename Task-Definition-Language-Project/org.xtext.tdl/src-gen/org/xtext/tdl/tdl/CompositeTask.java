/**
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.tdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.tdl.tdl.CompositeTask#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.CompositeTask#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.xtext.tdl.tdl.TdlPackage#getCompositeTask()
 * @model
 * @generated
 */
public interface CompositeTask extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.tdl.tdl.TdlPackage#getCompositeTask_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.CompositeTask#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.tdl.tdl.Task}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tasks</em>' containment reference list.
   * @see org.xtext.tdl.tdl.TdlPackage#getCompositeTask_Tasks()
   * @model containment="true"
   * @generated
   */
  EList<Task> getTasks();

} // CompositeTask