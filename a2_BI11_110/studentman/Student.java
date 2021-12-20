package a2_BI11_110.studentman;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;;

/*
 * @attributes              
 *  id              Integer
 *  name            String
 *  phoneNumber     String
 *  address         String 
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 10^9
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 100	
 * @author Phung Gia Huy
 */
public class Student implements Comparable<Student>, Document{
	    private static final int MIN_ID = 1 ;
	    private static final int MAX_ID = 1000000000 ;
	    private static final int LENGTH_NAME = 50;
	    private static final int LENGTH_PHONENUMBER = 10;
	    private static final int LENGTH_ADDRESS = 100;
	
		@DomainConstraint(type = "Integer",mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
		private int id;
		@DomainConstraint(type = "String",mutable = true, optional = false, length = 50)
		private String name;
		@DomainConstraint(type = "String",mutable = true, optional = false, length = 10)
		private String phoneNumber;
		@DomainConstraint(type = "String",mutable = true, optional = false, length = 100)
		private String address;		
		
		
		
		public Student() {
			
		}
		
		
		public Student(@AttrRef("id") int id, @AttrRef("name") String name, 
				@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)  throws NotPossibleException {
			if (!validateId(id)) {
				throw new NotPossibleException("Student.init: invalid id: " + id) ;
			}
			if (!validateName(name)) {
				throw new NotPossibleException("Student.init: invalid name: " + name) ;
			}
			if (!validatePhoneNumber(phoneNumber)) {
				throw new NotPossibleException("Student.init: invalid phoneNumber: " + phoneNumber) ;
			}
			if (!validateAddress(address)) {
				throw new NotPossibleException("Student.init: invalid address: " + address) ;
			}
			this.id = id ;
			this.name = name ;
			this.phoneNumber = phoneNumber ;
			this.address = address ;

		}



		private boolean validateAddress(String address) {
			if (address == null) {
				return false ;
			} else if (address.length() > LENGTH_ADDRESS) {
				return false ;
			} else {
				return true ;
			}
		}


		private boolean validatePhoneNumber(String phoneNumber) {
			if (phoneNumber == null) {
				return false ;
			} else if (phoneNumber.length() > LENGTH_PHONENUMBER) {
				return false ;
			} else {
				return true ;
			}
		}


		private boolean validateName(String name) {
			if (name == null) {
				return false ;
			}else if (name.length() > LENGTH_NAME) {
				return false ;
			} else {
				return true ;
			}
		}


		protected boolean validateId(int id) {
			if (id < MIN_ID) {
				return false ;
			} else if (id > MAX_ID) {
				return false ;
			} else {
				return true ;
			}
		}
		
		public boolean repOK() {
		    return validate(id, name, phoneNumber, address);
		}


		private boolean validate(int id, String name, String phoneNumber, String address) {
			// TODO Auto-generated method stub
			return validateId(id) && validateName(name) && validatePhoneNumber(phoneNumber) && validateAddress(address);
		}

		@DOpt(type=OptType.Observer) @AttrRef("id")
		public int getId() {
			return id;
		}
		
		@DOpt(type=OptType.Mutator) @AttrRef("id")
		public void setId(int id) throws NotPossibleException {
			if (validateId(id)) {
				this.id = id ;
			} else {
				throw new NotPossibleException ("Student.init: invalid id: " + id) ;
			}
        }
		
		@DOpt(type=OptType.Observer) @AttrRef("name")
		public String getName() {
			return name;
		}
		@DOpt(type=OptType.Mutator) @AttrRef("name")
		public void setName(String name)  throws NotPossibleException {
			if (validateName(name)) {
				this.name = name ;
			} else {
				throw new NotPossibleException ("Student.init: invalid name: " + name) ;
			}
		}
		
		@DOpt(type=OptType.Observer) @AttrRef("phoneNumber")
		public String getPhoneNumber() {
			return phoneNumber;
		}
		
		@DOpt(type=OptType.Mutator) @AttrRef("phoneNumber")
		public void setPhoneNumber(String phoneNumber)throws NotPossibleException {
			if (validatePhoneNumber(phoneNumber)) {
				this.phoneNumber = phoneNumber ;
			} else {
				throw new NotPossibleException("Student.init: invalid phoneNumber: " + phoneNumber) ;
			}
		}
		
		@DOpt(type=OptType.Observer) @AttrRef("address")
		public String getAddress() {
			return address;
		}
		
		@DOpt(type=OptType.Mutator) @AttrRef("address")
		public void setAddress(String address) throws NotPossibleException {
			if (validateAddress(address)) {
				this.address = address ;
			} else {
				throw new NotPossibleException("Student.init: invalid address: " + address) ;
			}
		}
		
		@Override
		public String toString() {
			return "Student[id:"+ id + ",name:"+ name +",phone number:" + phoneNumber +",address:"+address +"]";
		}
		
		@Override
		public int compareTo(Student student) throws NullPointerException, ClassCastException{
			 if (student == null)
			      throw new NullPointerException("Vehicle.compareByName");
			    else if (!(student instanceof Student))
			      throw new ClassCastException("Student.compareByName: not a Student " + student);
			    
			    Student s = (Student) student;
			    return this.name.compareTo(s.name);
		}


		@Override
		public void addDocumentListener(DocumentListener listener) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void addUndoableEditListener(UndoableEditListener listener) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public Position createPosition(int offs) throws BadLocationException {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Element getDefaultRootElement() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Position getEndPosition() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public int getLength() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public Object getProperty(Object key) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Element[] getRootElements() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Position getStartPosition() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public String getText(int arg0, int arg1) throws BadLocationException {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void getText(int arg0, int arg1, Segment arg2) throws BadLocationException {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void putProperty(Object arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void remove(int arg0, int arg1) throws BadLocationException {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void removeDocumentListener(DocumentListener listener) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void removeUndoableEditListener(UndoableEditListener listener) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void render(Runnable r) {
			// TODO Auto-generated method stub
			
		}
}
