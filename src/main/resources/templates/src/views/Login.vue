<template>
  <div class="login">
    <fieldset>
      <legend><h2>Login</h2></legend>
      <form action="/api/endpoint" method="post">
        <ul>
          <li>
            <input type="email" name="email" placeholder="E-mail" />
          </li>
          <li>
            <input type="password" name="password" placeholder="Lösenord" />
          </li>
          <li><input type="submit" value="Logga in" /></li>
        </ul>
      </form>
    </fieldset>
  </div>
</template>
<script>
export default {};
</script>
