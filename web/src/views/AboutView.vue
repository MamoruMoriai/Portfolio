<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
  <CareerDetailForm />
</template>

<script>
import CareerDetailForm from '@/components/CareerDetailForm.vue'

export default {
  name: 'AboutView',
  components: {
    CareerDetailForm
  }
}
</script>