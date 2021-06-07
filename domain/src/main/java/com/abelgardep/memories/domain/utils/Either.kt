package com.abelgardep.memories.domain.utils


/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Failure] or [Success].
 */
sealed class Either<out FailureType, out SuccessType> {
    /** * Represents the left side of [Either] class which by convention is a "Failure". */
    data class Failure<out FailureType>(val a: FailureType) : Either<FailureType, Nothing>()

    /** * Represents the right side of [Either] class which by convention is a "Success". */
    data class Success<out SuccessType>(val b: SuccessType) : Either<Nothing, SuccessType>()

    /**
     * Returns true if this is a Failure, false otherwise.
     * @see Failure
     */
    val isFailure get() = this is Failure<FailureType>

    /**
     * Returns true if this is a Success, false otherwise.
     * @see Success
     */
    val isSuccess get() = this is Success<SuccessType>

    /**
     * Creates a Failure type.
     * @see Failure
     */
    fun <FailureType> failure(a: FailureType) = Failure(a)

    /**
     * Creates a Success type.
     * @see Success
     */
    fun <SuccessType> success(b: SuccessType) = Success(b)

    /**
     * Applies failAction if this is a Failure or successAction if this is a Success.
     * @see Failure
     * @see Success
     */
    fun fold(failAction: (FailureType) -> Any, successAction: (SuccessType) -> Any): Any =
        when (this) {
            is Failure -> failAction(a)
            is Success -> successAction(b)
        }
}
