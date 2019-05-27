/**
 * generated by Xtext 2.12.0
 */
package org.xtext.tdl.tdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ros Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.tdl.tdl.RosNode#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.RosNode#getCodeBlock <em>Code Block</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.RosNode#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.RosNode#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.RosNode#getNodeArgs <em>Node Args</em>}</li>
 *   <li>{@link org.xtext.tdl.tdl.RosNode#getParameterList <em>Parameter List</em>}</li>
 * </ul>
 *
 * @see org.xtext.tdl.tdl.TdlPackage#getRosNode()
 * @model
 * @generated
 */
public interface RosNode extends EObject
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
   * @see org.xtext.tdl.tdl.TdlPackage#getRosNode_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.RosNode#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Code Block</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Block</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Block</em>' attribute.
   * @see #setCodeBlock(String)
   * @see org.xtext.tdl.tdl.TdlPackage#getRosNode_CodeBlock()
   * @model
   * @generated
   */
  String getCodeBlock();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.RosNode#getCodeBlock <em>Code Block</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code Block</em>' attribute.
   * @see #getCodeBlock()
   * @generated
   */
  void setCodeBlock(String value);

  /**
   * Returns the value of the '<em><b>Node Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Type</em>' attribute.
   * @see #setNodeType(String)
   * @see org.xtext.tdl.tdl.TdlPackage#getRosNode_NodeType()
   * @model
   * @generated
   */
  String getNodeType();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.RosNode#getNodeType <em>Node Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Type</em>' attribute.
   * @see #getNodeType()
   * @generated
   */
  void setNodeType(String value);

  /**
   * Returns the value of the '<em><b>Node Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Name</em>' attribute.
   * @see #setNodeName(String)
   * @see org.xtext.tdl.tdl.TdlPackage#getRosNode_NodeName()
   * @model
   * @generated
   */
  String getNodeName();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.RosNode#getNodeName <em>Node Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Name</em>' attribute.
   * @see #getNodeName()
   * @generated
   */
  void setNodeName(String value);

  /**
   * Returns the value of the '<em><b>Node Args</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Args</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Args</em>' attribute.
   * @see #setNodeArgs(String)
   * @see org.xtext.tdl.tdl.TdlPackage#getRosNode_NodeArgs()
   * @model
   * @generated
   */
  String getNodeArgs();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.RosNode#getNodeArgs <em>Node Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Args</em>' attribute.
   * @see #getNodeArgs()
   * @generated
   */
  void setNodeArgs(String value);

  /**
   * Returns the value of the '<em><b>Parameter List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter List</em>' containment reference.
   * @see #setParameterList(ParameterList)
   * @see org.xtext.tdl.tdl.TdlPackage#getRosNode_ParameterList()
   * @model containment="true"
   * @generated
   */
  ParameterList getParameterList();

  /**
   * Sets the value of the '{@link org.xtext.tdl.tdl.RosNode#getParameterList <em>Parameter List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter List</em>' containment reference.
   * @see #getParameterList()
   * @generated
   */
  void setParameterList(ParameterList value);

} // RosNode