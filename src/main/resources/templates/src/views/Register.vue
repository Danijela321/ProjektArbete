<template>
  <div class="register">
    <form method="POST">
      <fieldset>
        <legend>
          <h2>Register</h2>
        </legend>
        <ul>
          <li><input type="text" name="name" placeholder="Förnamn" /></li>
          <li><input type="text" name="surname" placeholder="Efternamn" /></li>
          <li><input type="email" name="email" placeholder="E-mail" /></li>
          <li>
            <input type="password" name="password" placeholder="Lösenord" />
          </li>
          <li><input type="submit" value="Skapa konto" /></li>
        </ul>
      </fieldset>
    </form>
  </div>
</template>
<script>
export default {};
</script>
