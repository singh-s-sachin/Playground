package lld;

import java.util.List;
import java.util.Map;

public class PhoneBook {

    /**
     * X-Phone number
     * 99
     *
     *
     * Indexed column of RDBMS
     *
     *       1
     *      2
     *     3  6
     *    4  6 9
     */


    List<Contact> contacts;

    class DialPad {
        String entry;

        public List<String> getSuggestions() {
            //code goes here
            return null;
        }

        public Contact getContact() {
            //code goes here
            return null;
        }

        public void makeCall() {   //Out of apprach
            //code goes here
        }
    }

    class Contact {
        String name;
        Map<ContactType, String> numbers;

        public void addNumber(ContactType contactType, String number) {
            //code goes here
        }  //Appending to the tree.

        public void delete() {
            //code goes here
        } //Traverse and delete the respective nodes.

        public void updateNumber(ContactType contactType, String number) {
            //code goes here
        }  //Traverse and update the nodes.
    }

    enum ContactType {
        HOME, BUSINESS, WORK
    }

}