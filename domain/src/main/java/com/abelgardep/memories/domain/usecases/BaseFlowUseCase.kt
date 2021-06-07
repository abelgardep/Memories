package com.abelgardep.memories.domain.usecases

import android.util.Log
import com.abelgardep.memories.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*


/**
 * Executes business logic in its execute method and keep posting updates to the result as
 * [UseCaseResult<R>].
 * Handling an exception (emit [Either.Failure] to the result) is the subclasses's responsibility.
 */
abstract class BaseFlowUseCase<in Params, Type> {

    suspend fun execute(params: Params): Flow<Either<Throwable, Type>> =
        flow<Either<Throwable, Type>> {
            call(params).collect {
                emit(Either.Success(it))
            }
        }.catch { cause: Throwable ->
            Log.e(javaClass.canonicalName, cause.message, cause)
            emit(Either.Failure(cause))
        }.flowOn(Dispatchers.IO)

    protected abstract suspend fun call(params: Params): Flow<Type>

}
