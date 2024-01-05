<template>
  <v-form>
    <h1 class="display-1 my-5 p-50">감정 입력</h1>
    <v-row>
      <v-col cols="12">
        <v-text-field
            v-model="message"
            :append-icon="'mdi-send'"
            variant="filled"
            clear-icon="mdi-close-circle"
            clearable
            label="감정을 입력해주세요"
            type="text"
            @click:append="sendMessage"
            @click:clear="clearMessage"
        ></v-text-field>
      </v-col>
    </v-row>
  </v-form>
</template>
`
<script setup>

let message = ''

const sendMessage = () => {
  clearMessage()
}

const clearMessage = () => {
  message = ''
}

</script>

<style lang="scss" scoped>

</style>