package com.allerap.android.pulsechallenge.data.remote

import android.util.Log
import retrofit2.Call
import java.io.IOException
import com.allerap.android.pulsechallenge.data.result.Err
import com.allerap.android.pulsechallenge.data.result.Ok
import com.allerap.android.pulsechallenge.data.result.Result
import com.allerap.android.pulsechallenge.data.entities.Error

open class BaseRemoteSource {

    internal fun <T> call(call: Call<T>): Result<T, Error> = try {

        val response = call.execute()

        if (response.isSuccessful && response.body() != null) {
            // Ignore the !!. A NPE will never be thrown here.
            Ok(response.body()!!)
        } else {
            Log.e("BaseRemoteSource",
                    "code: ${response.code()} message: ${response.message()}"
            )
            Err(Error("Try later"))
        }
    } catch (e: IOException) {
        Log.e("BaseRemoteSource", e.localizedMessage)
        Err(Error("Check your network"))
    } catch (e: Exception) {
        Log.e("BaseRemoteSource", e.localizedMessage)
        Err(Error("Internal Server Drama, try later"))
    }
}
