package Model;

import Model.InpediaObjects.ApiKey;
import Model.InpediaObjects.Query;
import Model.InpediaObjects.SearhOutput;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * Created by jatin on 8/9/16.
 */


//All functions are given here but will call client Function as Client got the

@AllArgsConstructor
public class Index<T> {

    private String name;
    private Class<T> indexClass;
    private InpediaClient client;

    public String getName() {
        return name;
    }

    public Class<T> getIndexClass() {
        return indexClass;
    }

    public boolean addObject(@NonNull T object) {

        return false;
    }

    public boolean addObject(@NonNull T Object, @NonNull String objectId) {
        return false;
    }

    public boolean addObjects(@NonNull List<T> objects) {
        return false;
    }

    public T getObject(@NonNull String objectID) {
        return null;
    }

    public List<T> getObjects(@NonNull List<String> objectIDs) {
        return null;
    }

    public List<T> getObjects(@NonNull List<String> objectIDs, @NonNull List<String> attributesToRetrieve) {
        return null;
    }

    public SearhOutput<T> search(@NonNull Query query) {
       // return client.search(name, query, klass);
        return null;
    }
    public boolean deleteIndex() {
        return false;
    }

    public Boolean deleteObject(@NonNull String objectID) {
        return false;
    }

    public Boolean deleteObjects(@NonNull List<String> objectIDs) {
        return false;
    }

    public Boolean deleteKey(@NonNull String key) {
        return false;
    }

    public boolean clear() {
        return false;
    }

    public List<ApiKey> lisyKeys() {
        return null;
    }
}



/*
package com.algolia.search;

import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.inputs.BatchOperation;
import com.algolia.search.inputs.partial_update.PartialUpdateOperation;
import com.algolia.search.inputs.synonym.AbstractSynonym;
import com.algolia.search.objects.ApiKey;
import com.algolia.search.objects.IndexSettings;
import com.algolia.search.objects.Query;
import com.algolia.search.objects.SynonymQuery;
import com.algolia.search.objects.tasks.sync.Task;
import com.algolia.search.objects.tasks.sync.TaskIndexing;
import com.algolia.search.objects.tasks.sync.TaskSingleIndex;
import com.algolia.search.responses.CreateUpdateKey;
import com.algolia.search.responses.DeleteKey;
import com.algolia.search.responses.SearchResult;
import com.algolia.search.responses.SearchSynonymResult;
import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("WeakerAccess")
public class Index<T> extends AbstractIndex<T> {

//    /**
//     * Get several objects from this index
//     *
//     * @param objectIDs the list of unique identifier of objects to retrieve
//     * @return the list of objects
//     * @throws AlgoliaException
//     */
//
//    /**
//     * Delete the index content without removing settings and index specific API keys.
//     *
//     * @return the related Task
//     * @throws AlgoliaException
//
//    /**
//     * Override the content of object
//     *
//     * @param objectID the unique identifier of the object to retrieve
//     * @param object   the object to update
//     * @return the related Task
//     * @throws AlgoliaException
//     */
//    public Task saveObject(@Nonnull String objectID, @Nonnull T object) throws AlgoliaException {
//        return client.saveObject(name, objectID, object);
//    }
//
//    /**
//     * Override the content
//     * @param objectID the unique identifier of the object to retrieve

//     * @param objectIDs the list of unique identifier of the object to retrieve
//     * @return the related Task
//     * @throws AlgoliaException
//     */
//    public TaskSingleIndex deleteObjects(@Nonnull List<String> objectIDs) throws AlgoliaException {
//        return client.deleteObjects(name, objectIDs);
//    }
//
//    /**
//     * Get settings of this index
//     *
//     * @return the settings
//     * @throws AlgoliaException
//     */
//    public IndexSettings getSettings() throws AlgoliaException {
//        return client.getSettings(name);
//    }
//
//    /**
//     * Set settings of this index, and do not forward to slaves
//     *
//     * @param settings the settings to set
//     * @return the related Task
//     * @throws AlgoliaException
//     */
//    public Task setSettings(@Nonnull IndexSettings settings) throws AlgoliaException {
//        return setSettings(settings, false);
//    }
//
//    /**
//     * Set settings of this index
//     *
//     * @param settings        the settings to set
//     * @param forwardToSlaves should these updates be forwarded to the slaves
//     * @return the related Task
//     * @throws AlgoliaException
//     */
//    public Task setSettings(@Nonnull IndexSettings settings, @Nonnull Boolean forwardToSlaves) throws AlgoliaException {
//        return client.setSettings(name, settings, forwardToSlaves);
//    }
//
//    /**
//     * List keys of this index
//     *
//     * @return the list of keys
//     * @throws AlgoliaException
//     */
//    public List<ApiKey> listKeys() throws AlgoliaException {
//        return client.listKeys(name);
//    }
//
//    /**
//     * Get a key by name from this index
//     *
//     * @param key the key name
//     * @return the key
//     * @throws AlgoliaException
//     */
//    public Optional<ApiKey> getKey(@Nonnull String key) throws AlgoliaException {
//        return client.getKey(name, key);
//    }
//
//    /**
//     * Delete a key by name from this index
//     *
//     * @param key the key name
//     * @return the deleted key
//     * @throws AlgoliaException
//     */
//    public DeleteKey deleteKey(@Nonnull String key) throws AlgoliaException {
//        return client.deleteKey(name, key);
//    }
//
//    /**
//     * Add a key to this index
//     *
//     * @param key the key
//     * @return the created key
//     * @throws AlgoliaException
//     */
//    public CreateUpdateKey addKey(@Nonnull ApiKey key) throws AlgoliaException {
//        return client.addKey(name, key);
//    }
//
//    /**
//     * Update a key by name from this index
//     *
//     * @param keyName the key name
//     * @param key     the key to update
//     * @return the updated key
//     * @throws AlgoliaException
//     */
//    public CreateUpdateKey updateKey(@Nonnull String keyName, @Nonnull ApiKey key) throws AlgoliaException {
//        return client.updateKey(name, keyName, key);
//    }
//
//    /**
//     * Moves an existing index
//     *
//     * @param dstIndexName the new index name that will contains a copy of srcIndexName (destination will be overriten if it already exist)
//     * @return The task associated
//     * @throws AlgoliaException
//     */
//    public Task moveTo(@Nonnull String dstIndexName) throws AlgoliaException {
//        return client.moveIndex(name, dstIndexName);
//    }
//
//    /**
//     * Copy an existing index
//     *
//     * @param dstIndexName the new index name that will contains a copy of srcIndexName (destination will be overridden if it already exist)
//     * @return The task associated
//     * @throws AlgoliaException
//     */
//    public Task copyTo(@Nonnull String dstIndexName) throws AlgoliaException {
//        return client.copyIndex(name, dstIndexName);
//    }
//
//    /**
//     * Search in the index
//     *
//     * @param query the query
//     * @return the result of the search
//     * @throws AlgoliaException
//     */
//    public SearchResult<T> search(@Nonnull Query query) throws AlgoliaException {
//        return client.search(name, query, klass);
//    }
//
//    /**
//     * Custom batch
//     * <p>
//     * All operations must have index name set to <code>null</code>
//     *
//     * @param operations the list of operations to perform on this index
//     * @return the associated task
//     * @throws AlgoliaException
//     * @see BatchOperation & subclasses
//     */
//    public TaskSingleIndex batch(@Nonnull List<BatchOperation> operations) throws AlgoliaException {
//        return client.batch(name, operations);
//    }
//
//    /**
//     * Partially update an object
//     *
//     * @param objectID the ID of object to update
//     * @param object   the object to update
//     * @return the associated task
//     * @throws AlgoliaException
//     * @see PartialUpdateOperation & subclasses
//     */
//    public TaskSingleIndex partialUpdateObject(@Nonnull String objectID, @Nonnull Object object) throws AlgoliaException {
//        return client.partialUpdateObject(name, objectID, object);
//    }
//
//    /**
//     * Partially update a objects
//     *
//     * @param objects the list of objects to update (with an objectID)
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public TaskSingleIndex partialUpdateObjects(@Nonnull List<Object> objects) throws AlgoliaException {
//        return client.partialUpdateObjects(name, objects);
//    }
//
//    /**
//     * Partially update an object, create the object if it does not exist
//     *
//     * @param operation the operation to perform on this object
//     * @return the associated task
//     * @throws AlgoliaException
//     * @see PartialUpdateOperation & subclasses
//     */
//    public TaskSingleIndex partialUpdateObject(@Nonnull PartialUpdateOperation operation) throws AlgoliaException {
//        return partialUpdateObject(operation, true);
//    }
//
//    /**
//     * Partially update an object
//     *
//     * @param operation         the operation to perform on this object
//     * @param createIfNotExists should the object be created or not
//     * @return the associated task
//     * @throws AlgoliaException
//     * @see PartialUpdateOperation & subclasses
//     */
//    public TaskSingleIndex partialUpdateObject(@Nonnull PartialUpdateOperation operation, boolean createIfNotExists) throws AlgoliaException {
//        return client.partialUpdateObject(name, operation, createIfNotExists);
//    }
//
//    /**
//     * Saves/updates a synonym without replacing it and NOT forwarding it to the slaves
//     *
//     * @param synonymID the id of the synonym
//     * @param content   the synonym
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task saveSynonym(@Nonnull String synonymID, @Nonnull AbstractSynonym content) throws AlgoliaException {
//        return saveSynonym(synonymID, content, false);
//    }
//
//    /**
//     * Saves/updates a synonym without replacing
//     *
//     * @param synonymID       the id of the synonym
//     * @param content         the synonym
//     * @param forwardToSlaves should this request be forwarded to slaves
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task saveSynonym(@Nonnull String synonymID, @Nonnull AbstractSynonym content, boolean forwardToSlaves) throws AlgoliaException {
//        return saveSynonym(synonymID, content, forwardToSlaves, false);
//    }
//
//    /**
//     * Saves/updates a synonym
//     *
//     * @param synonymID               the id of the synonym
//     * @param content                 the synonym
//     * @param forwardToSlaves         should this request be forwarded to slaves
//     * @param replaceExistingSynonyms should replace if this synonyms exists
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task saveSynonym(@Nonnull String synonymID, @Nonnull AbstractSynonym content, boolean forwardToSlaves, boolean replaceExistingSynonyms) throws AlgoliaException {
//        return client.saveSynonym(name, synonymID, content, forwardToSlaves, replaceExistingSynonyms);
//    }
//
//    /**
//     * Get a synonym by ID
//     *
//     * @param synonymID the id of the synonym
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Optional<AbstractSynonym> getSynonym(@Nonnull String synonymID) throws AlgoliaException {
//        return client.getSynonym(name, synonymID);
//    }
//
//    /**
//     * Deletes a synonym by ID and NOT forwarding it to the slaves
//     *
//     * @param synonymID the id of the synonym
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task deleteSynonym(@Nonnull String synonymID) throws AlgoliaException {
//        return deleteSynonym(synonymID, false);
//    }
//
//    /**
//     * Deletes a synonym
//     *
//     * @param synonymID       the id of the synonym
//     * @param forwardToSlaves should this request be forwarded to slaves
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task deleteSynonym(@Nonnull String synonymID, boolean forwardToSlaves) throws AlgoliaException {
//        return client.deleteSynonym(name, synonymID, forwardToSlaves);
//    }
//
//    /**
//     * Clear all synonyms and NOT forwarding it to the slaves
//     *
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task clearSynonyms() throws AlgoliaException {
//        return clearSynonyms(false);
//    }
//
//    /**
//     * Clears all synonyms
//     *
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task clearSynonyms(boolean forwardToSlaves) throws AlgoliaException {
//        return client.clearSynonyms(name, forwardToSlaves);
//    }
//
//    /**
//     * Search for synonyms
//     *
//     * @param query the query
//     * @return the results of the query
//     * @throws AlgoliaException
//     */
//    public SearchSynonymResult searchSynonyms(@Nonnull SynonymQuery query) throws AlgoliaException {
//        return client.searchSynonyms(name, query);
//    }
//
//    /**
//     * Add or Replace a list of synonyms
//     *
//     * @param synonyms                List of synonyms
//     * @param forwardToSlaves         Forward the operation to the slave indices
//     * @param replaceExistingSynonyms Replace the existing synonyms with this batch
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task batchSynonyms(@Nonnull List<AbstractSynonym> synonyms, boolean forwardToSlaves, boolean replaceExistingSynonyms) throws AlgoliaException {
//        return client.batchSynonyms(name, synonyms, forwardToSlaves, replaceExistingSynonyms);
//    }
//
//    /**
//     * Add or Replace a list of synonyms, no replacement
//     *
//     * @param synonyms        List of synonyms
//     * @param forwardToSlaves Forward the operation to the slave indices
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task batchSynonyms(@Nonnull List<AbstractSynonym> synonyms, boolean forwardToSlaves) throws AlgoliaException {
//        return batchSynonyms(synonyms, forwardToSlaves, false);
//    }
//
//    /**
//     * Add or Replace a list of synonyms, no forward to slaves, and no replacement
//     *
//     * @param synonyms List of synonyms
//     * @return the associated task
//     * @throws AlgoliaException
//     */
//    public Task batchSynonyms(@Nonnull List<AbstractSynonym> synonyms) throws AlgoliaException {
//        return batchSynonyms(synonyms, false, false);
//    }
//
//    /**
//     * Browse all the content of this index
//     *
//     * @param query The query to use to browse
//     * @return the iterator on top of this index
//     * @throws AlgoliaException
//     */
//    public IndexIterable<T> browse(@Nonnull Query query) throws AlgoliaException {
//        return new IndexIterable<>(client, name, query, klass);
//    }
//
//    /**
//     * Browse all the content of this index
//     *
//     * @param query  The query to use to browse
//     * @param cursor the cursor to start from
//     * @return the iterator on top of this index
//     * @throws AlgoliaException
//     */
//    public IndexIterable<T> browseFrom(@Nonnull Query query, @Nullable String cursor) throws AlgoliaException {
//        return new IndexIterable<>(client, name, query, cursor, klass);
//    }
//
//    /**
//     * Delete records matching a query, with a batch size of 1000, internally uses browse
//     *
//     * @param query The query
//     * @throws AlgoliaException
//     */
//    public void deleteByQuery(@Nonnull Query query) throws AlgoliaException {
//        client.deleteByQuery(name, query, 1000);
//    }
//
//    /**
//     * Delete records matching a query, internally uses browse
//     *
//     * @param query     The query
//     * @param batchSize the size of the batches
//     * @throws AlgoliaException
//     */
//    public void deleteByQuery(@Nonnull Query query, int batchSize) throws AlgoliaException {
//        client.deleteByQuery(name, query, batchSize);
//    }
//
//@SuppressWarnings("unused")
//public static class Attributes {
//    private String name;
//    private String createdAt;
//    private String updatedAt;
//    private Integer entries;
//    private Integer dataSize;
//    private Integer fileSize;
//    private Integer lastBuildTimeS;
//    private Integer numberOfPendingTask;
//    private Boolean pendingTask;
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public Integer getEntries() {
//        return entries;
//    }
//
//    public Integer getDataSize() {
//        return dataSize;
//    }
//
//    public Integer getFileSize() {
//        return fileSize;
//    }
//
//    public Integer getLastBuildTimeS() {
//        return lastBuildTimeS;
//    }
//
//    public Integer getNumberOfPendingTask() {
//        return numberOfPendingTask;
//    }
//
//    public Boolean getPendingTask() {
//        return pendingTask;
//    }
//}
//
//}




