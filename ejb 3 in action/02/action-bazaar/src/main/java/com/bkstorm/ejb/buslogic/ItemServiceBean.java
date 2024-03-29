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

import com.bkstorm.ejb.persistence.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Item service - retrieves items from the database.
 */
@Stateless
public class ItemServiceBean implements ItemService {

    /**
     * Persistence Context
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item getItem(long itemId) {
        return entityManager.find(Item.class,itemId);
    }

    /**
     * Creates an item in the database
     * @param item
     */
    @Override
    public void createItem(Item item) {
        entityManager.persist(item);
    }

}
