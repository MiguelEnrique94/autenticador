package br.sp.gov.etec.autenticador.Service

import br.sp.gov.etec.autenticador.model.CadastroUsuarioRequest
import br.sp.gov.etec.autenticador.model.CadastroUsuarioResponse
import br.sp.gov.etec.autenticador.model.Login
import br.sp.gov.etec.autenticador.model.Produto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    @POST("cadastro-usuario")
   suspend fun cadastrarUsuario(@Body cadastroUsuario: CadastroUsuarioRequest) : Response<CadastroUsuarioResponse>

   @POST("autenticar")
   suspend fun autenticar(@Body Login : Login) : Response<Login>

   @GET("produtos")
   suspend fun listaDeProdutos() : Response<List<Produto>>
}