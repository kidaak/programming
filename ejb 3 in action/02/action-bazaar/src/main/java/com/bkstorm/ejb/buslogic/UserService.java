/**
 *  EJB 3 in Action
 *  Book: http://manning.com/panda2/
 *  Code: http://code.google.com/p/action-bazaar/
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.bkstorm.ejb.buslogic;

import com.bkstorm.ejb.persistence.Bidder;
import javax.ejb.Local;

/**
 * Manages users
 * Since we are running in the same container, this interface isn't necessary for
 * EJB 3.1 unless we wanted to "hide" public methods.
 */
@Local
public interface UserService {

    /**
     * Returns the user
     * @param userId - user
     * @return Bidder
     */
    Bidder getUser(long userId);

    /**
     * Sets the user
     * @param bidder - bidder
     */
    void createUser(Bidder bidder);

}
