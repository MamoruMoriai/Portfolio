<template>

  <div class="container">
    <div class="row">
      
      <div class="card" style="width: 200px;" v-for="item in careerDetails" :key="item.id">
        <div class="btn" id="key" v-on:click="selectedEvent($event);">
          <img src="https://placehold.jp/250x200.png" class="card-img-top" v-bind:id="item.id">
          <div class="card-body" v-bind:id="item.id">
            <h5 class="card-title" v-bind:id="item.id">{{ item.title }}</h5>
            <p class="card-text" v-bind:id="item.id">{{ item.fromDateString }} ～ {{ item.toDateString }}</p>
          </div>
        </div>
      </div>
      
      <div v-show="open" class="card" id="modal">
      
        <div v-show="!edit" class="show_modal">
          <div v-on:click="closeModal"></div>
          <div class="modal-header">
            <div class="card-title" style="font-size:1.5em;">{{ careerDetailItem.title }}</div>
            <button v-on:click="editMode" type="button" class="btn bg-secondary text-white" style="padding:5px;">編集</button>
            <button v-on:click="closeModal" type="button" class="btn text-secondary" style="font-size:2em;">×</button>
          </div>
          <div class="modal-body">
            <div class="card-text">{{ careerDetailItem.fromDateString }} ～ {{ careerDetailItem.toDateString }}</div>
            <div class="card-text">{{ careerDetailItem.content }}</div>
          </div>
        </div>
        
        <div v-show="edit" class="show_modal">
          <div v-on:click="closeModal"></div>
          <div class="form">
            <div class="modal-header">
              <input type="text" v-model="this.careerDetailItem.title" placeholder="">
              <button v-on:click="showMode" type="button" class="btn bg-secondary text-white" style="padding:5px;">表示</button>
              <button v-on:click="closeModal" type="button" class="btn text-secondary" style="font-size:2em;">×</button>
            </div>
            <div class="modal-body">
              <input type="date" v-model="this.formattedFromDate"> ～ 
              <input type="date" v-model="this.formattedToDate">
              <textarea class="careerDetailTextarea" style="margin:10px;" v-model="careerDetailItem.content" rows="8" cols="70"></textarea>
              <div class="formButton">
                <button v-on:click="showMode" type="button" class="cancelButton btn bg-secondary text-white">キャンセル</button>
                <button v-on:click="updateCareerDetail" type="button" class="updateButton btn bg-success text-white">更新</button>
              </div>
            </div>
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
      edit: false,
      careerDetailItem: {
        id: "",
        externalFlg: true,
        fromDate: null,
        fromDateString: '',
        toDate: null,
        toDateString: '',
        title: "",
        content: ""
      },
      formattedFromDate: null,
      formattedToDate: null
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
    selectedEvent(event) {
      this.id = event.target.id
      this.selectedCareerDetail(this.id)
    },
    selectedCareerDetail(id) {
      const path = 'http://localhost:8080/test'
      axios.get(path + "/" + id).then(response => {
        this.careerDetail = response.data
        this.careerDetailItem.id = this.careerDetail.id
        this.careerDetailItem.fromDate = this.careerDetail.fromDate
        this.careerDetailItem.fromDateString = this.careerDetail.fromDateString
        this.careerDetailItem.toDate = this.careerDetail.toDate
        this.careerDetailItem.toDateString = this.careerDetail.toDateString
        this.careerDetailItem.title = this.careerDetail.title
        this.careerDetailItem.content = this.careerDetail.content
        this.formatFromDate()
        this.formatToDate()
      }).catch(error => {
        console.log(error)
      })
      this.open = true
    },
    updateCareerDetail() {
      const path = 'http://localhost:8080/test/${this.careerDetailItem.id}'
      console.log(this.careerDetailItem)
      axios.put(path, this.careerDetailItem)
      .then(
        alert('更新しました。')
      )
      .catch(error => {
        console.error('Error updating resource:', error)
      })
      this.showMode()
    },
    formatFromDate() {
      const parts = this.careerDetailItem.fromDateString.split("/")
      if (parts.length === 3) {
        const year = parts[0]
        const month = parts[1].padStart(2, "0")
        const day = parts[2].padStart(2, "0")
        this.formattedFromDate = `${year}-${month}-${day}`
      }
    },
    formatToDate() {
      const parts = this.careerDetailItem.toDateString.split("/")
      if (parts.length === 3) {
        const year = parts[0]
        const month = parts[1].padStart(2, "0")
        const day = parts[2].padStart(2, "0")
        this.formattedToDate = `${year}-${month}-${day}`
      }
    },
    editMode() {
      this.edit = true
    },
    showMode() {
      this.edit = false
    },
    closeModal() {
      this.open = false
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
  
  #modal {
    top: 50px;
    position: fixed;
    z-index: 1;
    border: solid 1.5px;
    width: 640px;
    height: 480px;
  }
  
  .formButton {
    text-align:right;
  }
  
  .updateButton {
    padding:10px;
    margin:10px;
  }
  
  .cancelButton {
    padding:10px;
    margin:10px;
  }
  
  
</style>
