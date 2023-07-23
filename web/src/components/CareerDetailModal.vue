<template>

  <div class="" id="overlay" v-on:click="closeModal">
    <p>Hello from the modal!</p>
  </div>

</template>

<script>
import axios from 'axios'

export default {
  name: 'careerDetailModal',
  props: {},
  data() {
    return {
      careerDetail: []
    }
  },
  methods: {
    getCareerDetail() {
      const path = 'http://localhost:8080/test'
      axios.post(path).then(response => {
        this.careerDetail = response.data
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },
    selectedCareerDetail(event) {
      console.log(event.target.id);
      
    }
  },
  created() {
    this.getCareerDetail()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  
  .row {
    margin: auto;
    width: 60%;
  }
  
  .card {
    margin: 10px;
  }
  
  .btn {
    padding: 0;
  }
  
</style>
