<template>
  <div class="careerDitail">
      
    <div v-for="value in careerDetails" v-bind:key='value'>
      {{ value }}
    </div>
    
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'careerDetail',
  props: {},
  data() {
    return {
      careerDetails: []
    }
  },
  methods: {
    getCareerDetails() {
      const path = 'http://localhost:8080/test'
      axios.get(path).then(response => {
        this.careerDetails = response.data
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    }
  },
  created() {
    this.getCareerDetails()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
