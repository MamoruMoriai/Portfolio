<template>

  <div class="container">
    <div class="row">
    
      <div class="card btn" v-on:click="createdEvent();" style="width: 200px; display: flex; justify-content: center;">
        <span class="text-secondary" style="font-size: 4em;">+</span>
      </div>
      
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
      
        <div v-show="!edit & !create" class="show_modal">
          <div v-on:click="closeModal"></div>
          <div class="modal-header">
            <div class="card-title" style="font-size:1.5em;">{{ careerDetailItem.title }}</div>
            <div class="icon">
              <img src="@/assets/edit.png" id="editImg" v-on:click="editMode" alt="Edit Image" />
            </div>
            <button v-on:click="closeModal" type="button" class="btn text-secondary" style="font-size:2em;">×</button>
          </div>
          <div class="modal-body">
            <div v-show="!careerDetailItem.externalFlg">社外業務</div>
            <div v-show="careerDetailItem.externalFlg">社内業務</div>
            <br>
            <div class="card-text">{{ careerDetailItem.fromDateString }} ～ {{ careerDetailItem.toDateString }}</div>
            <br>
            <div class="card-text">{{ careerDetailItem.content }}</div>
          </div>
        </div>
        
        <div v-show="edit" class="show_modal">
          <div v-on:click="closeModal"></div>
          <div class="form">
            <div class="modal-header">
              <input type="text" v-model="this.careerDetailItem.title" style="margin-left: 10px; font-size: 1.6em;">
              <button v-on:click="closeModal" type="button" class="btn text-secondary" style="font-size:2em;">×</button>
            </div>
            <div class="modal-body">
              <div>
                <label><input type="radio" v-model="careerDetailItem.externalFlg" value="true" style="margin-left: 10px;"> 社外業務 </label>
                <label><input type="radio" v-model="careerDetailItem.externalFlg" value="false" style="margin-left: 10px;"> 社内業務 </label>
              </div>
              <input type="date" v-model="this.formattedFromDate" style="margin-left: 10px;"> ～ 
              <input type="date" v-model="this.formattedToDate">
              <textarea class="careerDetailTextarea" style="margin:10px;" v-model="careerDetailItem.content" rows="8" cols="70"></textarea>
              <div class="formButton">
                <button v-on:click="showMode" type="button" class="button btn bg-secondary text-white">キャンセル</button>
                <button v-on:click="updateCareerDetail" type="button" class="button btn bg-success text-white">更新</button>
              </div>
            </div>
          </div>
        </div>
        
        <div v-show="create" class="show_modal">
          <div v-on:click="closeModal"></div>
          <div class="form">
            <div class="modal-header">
              <input type="text" v-model="this.careerDetailItem.title" placeholder="タイトルを入力" style="margin-left: 10px; font-size: 1.6em;">
              <button v-on:click="closeModal" type="button" class="btn text-secondary" style="font-size:2em;">×</button>
            </div>
            <div class="modal-body">
              <div>
                <label><input type="radio" v-model="careerDetailItem.externalFlg" value="true" style="margin-left: 10px;"> 社外業務 </label>
                <label><input type="radio" v-model="careerDetailItem.externalFlg" value="false" style="margin-left: 10px;"> 社内業務 </label>
              </div>
              <input type="date" v-model="this.formattedFromDate" style="margin-left: 10px;"> ～ 
              <input type="date" v-model="this.formattedToDate">
              <textarea class="careerDetailTextarea" style="margin:10px;" v-model="careerDetailItem.content" placeholder="コンテンツを入力" rows="8" cols="70"></textarea>
              <div class="formButton">
                <button v-on:click="deleteCareerDetail" type="button" class="button btn bg-danger text-white">削除</button>
                <button v-on:click="closeModal" type="button" class="button btn bg-secondary text-white">キャンセル</button>
                <button v-on:click="createCareerDetail" type="button" class="button btn bg-success text-white">登録</button>
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
      create: false,
      edit: false,
      careerDetailItem: {
        id: "",
        externalFlg: null,
        fromDate: null,
        fromDateString: "",
        toDate: null,
        toDateString: "",
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
        this.careerDetailItem.externalFlg = this.careerDetail.externalFlg
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
    createdEvent() {
      this.createMode()
      this.open = true
    },
    createCareerDetail() {
      this.careerDetailItem.fromDate = this.formattedFromDate;
      this.careerDetailItem.toDate = this.formattedToDate;
      const path = 'http://localhost:8080/test'
      console.log(this.careerDetailItem)
      axios.post(path, this.careerDetailItem)
      .then(
        alert('登録しました。')
      )
      .catch(error => {
        console.error('Error creating resource:', error)
      })
      this.showMode()
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
    deleteCareerDetail(id) {
      const path = 'http://localhost:8080/test'
      console.log(this.careerDetailItem)
      axios.delete(path + "/" + id)
      .then(
        alert('削除しました。')
      )
      .catch(error=>{
        console.log('Error deleting resource:', error)
      })
      this.closeModal()
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
    createMode() {
      this.create = true
    },
    editMode() {
      this.edit = true
    },
    showMode() {
      this.edit = false
    },
    closeModal() {
      this.showMode()
      this.careerDetailItem.id = ""
      this.careerDetailItem.fromDate = null
      this.careerDetailItem.fromDateString = ""
      this.careerDetailItem.toDate = null
      this.careerDetailItem.toDateString = ""
      this.careerDetailItem.title = ""
      this.careerDetailItem.content = ""
      this.formattedFromDate = ""
      this.formattedToDate = ""
      this.create = false
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
  
  #editImg {
    width: 20px;
    height: 20px;
  }
  
  .formButton {
    text-align:right;
  }
  
  .icon {
    padding:5px;
    margin:5px;
    display: flex;
    justify-content: flex-end;
  }
  
  .button {
    padding:10px;
    margin:10px;
  }
  
</style>
