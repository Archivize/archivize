package app.omnivore.omnivore.core.data.repository

import app.omnivore.omnivore.core.data.SavedItemSyncResult
import app.omnivore.omnivore.core.data.SearchResult
import app.omnivore.omnivore.core.data.model.LibraryQuery
import app.omnivore.omnivore.core.database.entities.HighlightChange
import app.omnivore.omnivore.core.database.entities.SavedItemLabel
import app.omnivore.omnivore.core.database.entities.SavedItemWithLabelsAndHighlights
import kotlinx.coroutines.flow.Flow

interface LibraryRepository  {

    fun getSavedItems(query: LibraryQuery): Flow<List<SavedItemWithLabelsAndHighlights>>

    fun getSavedItemsLabels(): Flow<List<SavedItemLabel>>

    suspend fun getLabels(): List<SavedItemLabel>

    suspend fun fetchSavedItemContent(slug: String)

    suspend fun insertAllLabels(labels: List<SavedItemLabel>)

    suspend fun setSavedItemLabels(itemId: String, labels: List<SavedItemLabel>): Boolean

    suspend fun updateReadingProgress(
        itemId: String,
        readingProgressPercentage: Double,
        readingProgressAnchorIndex: Int
    )

    suspend fun createNewSavedItemLabel(labelName: String, hexColorValue: String)

    suspend fun librarySearch(cursor: String?, query: String): SearchResult

    suspend fun isSavedItemContentStoredInDB(slug: String): Boolean

    suspend fun deleteSavedItem(itemID: String)

    suspend fun archiveSavedItem(itemID: String)

    suspend fun unarchiveSavedItem(itemID: String)

    suspend fun syncOfflineItemsWithServerIfNeeded()

    suspend fun syncHighlightChange(highlightChange: HighlightChange): Boolean

    suspend fun sync(since: String, cursor: String?, limit: Int = 20): SavedItemSyncResult
}
