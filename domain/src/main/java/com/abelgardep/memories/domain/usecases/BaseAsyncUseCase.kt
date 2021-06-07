package com.abelgardep.memories.domain.usecases

import android.util.Log
import com.abelgardep.memories.domain.utils.Either


abstract class BaseAsyncUseCase<in Params, out Type> {

    suspend fun execute(params: Params): Either<Throwable, Type> =
        try {
            Either.Success(call(params))
        } catch (throwable: Throwable) {
            Log.e(javaClass.canonicalName, throwable.message, throwable)
            Either.Failure(throwable)
        }

    protected abstract suspend fun call(params: Params): Type

}
