package app.omnivore.omnivore.core.network

import app.omnivore.omnivore.graphql.generated.GetLabelsQuery
import app.omnivore.omnivore.core.database.entities.SavedItemLabel


suspend fun Networker.savedItemLabels(): List<SavedItemLabel> {
  try {
    val result = authenticatedApolloClient().query(GetLabelsQuery()).execute()
    val labels = result.data?.labels?.onLabelsSuccess?.labels ?: listOf()

    return labels.map {
      SavedItemLabel(
        savedItemLabelId = it.labelFields.id,
        name = it.labelFields.name,
        color = it.labelFields.color,
        createdAt = it.labelFields.createdAt as String?,
        labelDescription = it.labelFields.description
      )
    }
  } catch (e: java.lang.Exception) {
    return listOf()
  }
}
