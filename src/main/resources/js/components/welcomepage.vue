<template>
<v-app>
     <v-toolbar dense :color="'#EF9A9A'">
         <v-toolbar-title><h1>Spibook</h1></v-toolbar-title>

         <v-spacer></v-spacer>
         <router-link to="/auth"><p>Auth</p></router-link>

     </v-toolbar>
    <v-container >
    </v-container>
</v-app>
</template>

<script>
    export default {
        mode: 'history',
        name: "WelcomePage"
    }
</script>

<style scoped>

</style>