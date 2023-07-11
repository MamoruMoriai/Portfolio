<template>

  <div class="container">
    <div class="row">
      <div class="card btn" style="width: 200px;" v-for="item in careerDetails" :key="item.id" v-on:click="selectedCareerDetail()">
        <img src="https://placehold.jp/250x200.png" class="card-img-top">
        <div class="card-body">
          <h5 class="card-title">{{ item.title }}</h5>
          <p class="card-text">{{ item.fromDate }} ～ {{ item.toDate }}</p>
        </div>
      </div>
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
    },
    selectedCareerDetail() {
      console.log("クリックされたよ");
    }
  },
  created() {
    this.getCareerDetails()
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
