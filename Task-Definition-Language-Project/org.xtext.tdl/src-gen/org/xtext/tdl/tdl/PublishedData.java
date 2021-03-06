/**
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.tdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Published Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.tdl.tdl.PublishedData#getTopics <em>Topics</em>}</li>
 * </ul>
 *
 * @see org.xtext.tdl.tdl.TdlPackage#getPublishedData()
 * @model
 * @generated
 */
public interface PublishedData extends EObject
{
  /**
   * Returns the value of the '<em><b>Topics</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.tdl.tdl.Topic}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Topics</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Topics</em>' containment reference list.
   * @see org.xtext.tdl.tdl.TdlPackage#getPublishedData_Topics()
   * @model containment="true"
   * @generated
   */
  EList<Topic> getTopics();

} // PublishedData
