package cloud.hendra.danantara.domain.model

import com.google.gson.annotations.SerializedName


data class LoginRequest(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String
)

data class LoginResponse(
    @SerializedName("access") val access: String
)
