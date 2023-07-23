<template>

  <div class="container">
    <div class="row">
    
      <div v-show="open" class="card" style="width: 640px;">
        <div class="modal_content">
          <div v-on:click="closeModal" class="modal_contents_bg"></div>
          <div class="modal-header">
            <div class="card-title" style="font-size:1.5em;">{{ title }}</div>
            <button v-on:click="closeModal" type="button" class="btn text-secondary" style="font-size:2em;">×</button>
          </div>
          <div class="modal-body">
            <div class="card-text">{{ content }}</div>
          </div>
        </div>
      </div>
      
      <div class="card" style="width: 200px;" v-for="item in careerDetails" :key="item.id">
        <div class="btn" id="key" v-on:click="selectedCareerDetail($event);">
          <img src="https://placehold.jp/250x200.png" class="card-img-top" v-bind:id="item.id">
          <div class="card-body" v-bind:id="item.id">
            <h5 class="card-title" v-bind:id="item.id">{{ item.title }}</h5>
            <p class="card-text" v-bind:id="item.id">{{ item.fromDate }} ～ {{ item.toDate }}</p>
          </div>
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
      careerDetails: [],
      open: false,
      id: "",
      title: "タイトル",
      content: "コンテンツ",
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
    selectedCareerDetail(event) {
      console.log(event.target.id)
      this.open = true
    },
    closeModal() {
      this.open = false;
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
