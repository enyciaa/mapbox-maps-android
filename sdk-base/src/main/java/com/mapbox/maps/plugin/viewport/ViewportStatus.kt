package com.mapbox.maps.plugin.viewport

import com.mapbox.maps.plugin.viewport.state.ViewportState
import com.mapbox.maps.plugin.viewport.transition.ViewportTransition
import java.util.*

/**
 * Represents the status of the viewport.
 *
 * It could be either a [ViewportState] or [ViewportTransition].
 */
sealed class ViewportStatus {
  /**
   * Represents the current status is a [ViewportState].
   *
   * The state is null if current status is IDLE.
   */
  class State(
    /**
     * The current [ViewportState].
     */
    val state: ViewportState?
  ) : ViewportStatus() {
    /**
     * Indicates whether some other object is "equal to" this one.
     */
    override fun equals(other: Any?): Boolean = other is State && other.state === this.state

    /**
     * Returns a hash code value for the object.
     */
    override fun hashCode() = Objects.hash(state)

    /**
     * Returns a String for the object.
     */
    override fun toString() = "ViewportStatus#State(state=$state)"
  }

  /**
   * Represents the current status is a [ViewportTransition].
   */
  class Transition(
    /**
     * The current [ViewportTransition].
     */
    val transition: ViewportTransition,
    /**
     * The previous [ViewportState].
     */
    val fromState: ViewportState?,
    /**
     * The target [ViewportState].
     */
    val toState: ViewportState
  ) : ViewportStatus() {
    /**
     * Indicates whether some other object is "equal to" this one.
     */
    override fun equals(other: Any?): Boolean =
      other is Transition &&
        other.transition === this.transition &&
        other.fromState === this.fromState &&
        other.toState === this.toState

    /**
     * Returns a hash code value for the object.
     */
    override fun hashCode() = Objects.hash(transition, fromState, toState)

    /**
     * Returns a String for the object.
     */
    override fun toString() =
      "ViewportStatus#Transition(transition=$transition, fromState=$fromState, toState=$toState)"
  }
}