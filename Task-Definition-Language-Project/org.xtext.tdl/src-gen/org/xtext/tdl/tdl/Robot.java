/**
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.tdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.tdl.tdl.Robot#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.Robot#getPublishedData <em>Published Data</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.Robot#getInitializationModule <em>Initialization Module</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.Robot#getSimpleActions <em>Simple Actions</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.Robot#getRosNodes <em>Ros Nodes</em>}</li>
 * </ul>
 *
 * @see org.xtext.tdl.tdl.TdlPackage#getRobot()
 * @model
 * @generated
 */
public interface Robot extends EObject
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
   * @see org.xtext.tdl.tdl.TdlPackage#getRobot_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.Robot#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Published Data</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Published Data</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Published Data</em>' containment reference.
   * @see #setPublishedData(PublishedData)
   * @see org.xtext.tdl.tdl.TdlPackage#getRobot_PublishedData()
   * @model containment="true"
   * @generated
   */
  PublishedData getPublishedData();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.Robot#getPublishedData <em>Published Data</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Published Data</em>' containment reference.
   * @see #getPublishedData()
   * @generated
   */
  void setPublishedData(PublishedData value);

  /**
   * Returns the value of the '<em><b>Initialization Module</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initialization Module</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initialization Module</em>' containment reference.
   * @see #setInitializationModule(InitializationModule)
   * @see org.xtext.tdl.tdl.TdlPackage#getRobot_InitializationModule()
   * @model containment="true"
   * @generated
   */
  InitializationModule getInitializationModule();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.Robot#getInitializationModule <em>Initialization Module</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initialization Module</em>' containment reference.
   * @see #getInitializationModule()
   * @generated
   */
  void setInitializationModule(InitializationModule value);

  /**
   * Returns the value of the '<em><b>Simple Actions</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.tdl.tdl.SimpleAction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Actions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Actions</em>' containment reference list.
   * @see org.xtext.tdl.tdl.TdlPackage#getRobot_SimpleActions()
   * @model containment="true"
   * @generated
   */
  EList<SimpleAction> getSimpleActions();

  /**
   * Returns the value of the '<em><b>Ros Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.tdl.tdl.RosNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ros Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ros Nodes</em>' containment reference list.
   * @see org.xtext.tdl.tdl.TdlPackage#getRobot_RosNodes()
   * @model containment="true"
   * @generated
   */
  EList<RosNode> getRosNodes();

} // Robot
