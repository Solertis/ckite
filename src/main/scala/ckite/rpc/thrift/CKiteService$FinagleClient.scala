/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package ckite.rpc.thrift

import com.twitter.finagle.SourcedException
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.ThriftClientRequest
import com.twitter.finagle.{Service => FinagleService}
import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import com.twitter.util.Future
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.{TMemoryBuffer, TMemoryInputTransport}
import scala.collection.{Map, Set}


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"), date = "2014-04-28T21:55:04.159-0300")
class CKiteService$FinagleClient(
  val service: FinagleService[ThriftClientRequest, Array[Byte]],
  val protocolFactory: TProtocolFactory = new TBinaryProtocol.Factory,
  val serviceName: String = "",
  stats: StatsReceiver = NullStatsReceiver
) extends CKiteService[Future] {
  import CKiteService._

  protected def encodeRequest(name: String, args: ThriftStruct) = {
    val buf = new TMemoryBuffer(512)
    val oprot = protocolFactory.getProtocol(buf)

    oprot.writeMessageBegin(new TMessage(name, TMessageType.CALL, 0))
    args.write(oprot)
    oprot.writeMessageEnd()

    val bytes = Arrays.copyOfRange(buf.getArray, 0, buf.length)
    new ThriftClientRequest(bytes, false)
  }

  protected def decodeResponse[T <: ThriftStruct](resBytes: Array[Byte], codec: ThriftStructCodec[T]) = {
    val iprot = protocolFactory.getProtocol(new TMemoryInputTransport(resBytes))
    val msg = iprot.readMessageBegin()
    try {
      if (msg.`type` == TMessageType.EXCEPTION) {
        val exception = TApplicationException.read(iprot) match {
          case sourced: SourcedException =>
            if (serviceName != "") sourced.serviceName = serviceName
            sourced
          case e => e
        }
        throw exception
      } else {
        codec.decode(iprot)
      }
    } finally {
      iprot.readMessageEnd()
    }
  }

  protected def missingResult(name: String) = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  // ----- end boilerplate.

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_sendRequestVote {
    val RequestsCounter = scopedStats.scope("sendRequestVote").counter("requests")
    val SuccessCounter = scopedStats.scope("sendRequestVote").counter("success")
    val FailuresCounter = scopedStats.scope("sendRequestVote").counter("failures")
    val FailuresScope = scopedStats.scope("sendRequestVote").scope("failures")
  }
  
  
  def sendRequestVote(requestVote: RequestVoteST): Future[RequestVoteResponseST] = {
    __stats_sendRequestVote.RequestsCounter.incr()
    this.service(encodeRequest("sendRequestVote", sendRequestVote$args(requestVote))) flatMap { response =>
      val result = decodeResponse(response, sendRequestVote$result)
      val exception =
        None
      exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("sendRequestVote")))
    } rescue {
      case ex: SourcedException => {
        if (this.serviceName != "") { ex.serviceName = this.serviceName }
        Future.exception(ex)
      }
    } onSuccess { _ =>
      __stats_sendRequestVote.SuccessCounter.incr()
    } onFailure { ex =>
      __stats_sendRequestVote.FailuresCounter.incr()
      __stats_sendRequestVote.FailuresScope.counter(ex.getClass.getName).incr()
    }
  }
  private[this] object __stats_sendAppendEntries {
    val RequestsCounter = scopedStats.scope("sendAppendEntries").counter("requests")
    val SuccessCounter = scopedStats.scope("sendAppendEntries").counter("success")
    val FailuresCounter = scopedStats.scope("sendAppendEntries").counter("failures")
    val FailuresScope = scopedStats.scope("sendAppendEntries").scope("failures")
  }
  
  
  def sendAppendEntries(appendEntries: AppendEntriesST): Future[AppendEntriesResponseST] = {
    __stats_sendAppendEntries.RequestsCounter.incr()
    this.service(encodeRequest("sendAppendEntries", sendAppendEntries$args(appendEntries))) flatMap { response =>
      val result = decodeResponse(response, sendAppendEntries$result)
      val exception =
        None
      exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("sendAppendEntries")))
    } rescue {
      case ex: SourcedException => {
        if (this.serviceName != "") { ex.serviceName = this.serviceName }
        Future.exception(ex)
      }
    } onSuccess { _ =>
      __stats_sendAppendEntries.SuccessCounter.incr()
    } onFailure { ex =>
      __stats_sendAppendEntries.FailuresCounter.incr()
      __stats_sendAppendEntries.FailuresScope.counter(ex.getClass.getName).incr()
    }
  }
  private[this] object __stats_forwardCommand {
    val RequestsCounter = scopedStats.scope("forwardCommand").counter("requests")
    val SuccessCounter = scopedStats.scope("forwardCommand").counter("success")
    val FailuresCounter = scopedStats.scope("forwardCommand").counter("failures")
    val FailuresScope = scopedStats.scope("forwardCommand").scope("failures")
  }
  
  
  def forwardCommand(command: ByteBuffer): Future[ByteBuffer] = {
    __stats_forwardCommand.RequestsCounter.incr()
    this.service(encodeRequest("forwardCommand", forwardCommand$args(command))) flatMap { response =>
      val result = decodeResponse(response, forwardCommand$result)
      val exception =
        None
      exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("forwardCommand")))
    } rescue {
      case ex: SourcedException => {
        if (this.serviceName != "") { ex.serviceName = this.serviceName }
        Future.exception(ex)
      }
    } onSuccess { _ =>
      __stats_forwardCommand.SuccessCounter.incr()
    } onFailure { ex =>
      __stats_forwardCommand.FailuresCounter.incr()
      __stats_forwardCommand.FailuresScope.counter(ex.getClass.getName).incr()
    }
  }
  private[this] object __stats_installSnapshot {
    val RequestsCounter = scopedStats.scope("installSnapshot").counter("requests")
    val SuccessCounter = scopedStats.scope("installSnapshot").counter("success")
    val FailuresCounter = scopedStats.scope("installSnapshot").counter("failures")
    val FailuresScope = scopedStats.scope("installSnapshot").scope("failures")
  }
  
  
  def installSnapshot(installSnapshot: InstallSnapshotST): Future[Boolean] = {
    __stats_installSnapshot.RequestsCounter.incr()
    this.service(encodeRequest("installSnapshot", installSnapshot$args(installSnapshot))) flatMap { response =>
      val result = decodeResponse(response, installSnapshot$result)
      val exception =
        None
      exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("installSnapshot")))
    } rescue {
      case ex: SourcedException => {
        if (this.serviceName != "") { ex.serviceName = this.serviceName }
        Future.exception(ex)
      }
    } onSuccess { _ =>
      __stats_installSnapshot.SuccessCounter.incr()
    } onFailure { ex =>
      __stats_installSnapshot.FailuresCounter.incr()
      __stats_installSnapshot.FailuresScope.counter(ex.getClass.getName).incr()
    }
  }
  private[this] object __stats_join {
    val RequestsCounter = scopedStats.scope("join").counter("requests")
    val SuccessCounter = scopedStats.scope("join").counter("success")
    val FailuresCounter = scopedStats.scope("join").counter("failures")
    val FailuresScope = scopedStats.scope("join").scope("failures")
  }
  
  
  def join(memberId: JoinRequestST): Future[JoinResponseST] = {
    __stats_join.RequestsCounter.incr()
    this.service(encodeRequest("join", join$args(memberId))) flatMap { response =>
      val result = decodeResponse(response, join$result)
      val exception =
        None
      exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("join")))
    } rescue {
      case ex: SourcedException => {
        if (this.serviceName != "") { ex.serviceName = this.serviceName }
        Future.exception(ex)
      }
    } onSuccess { _ =>
      __stats_join.SuccessCounter.incr()
    } onFailure { ex =>
      __stats_join.FailuresCounter.incr()
      __stats_join.FailuresScope.counter(ex.getClass.getName).incr()
    }
  }
  private[this] object __stats_getMembers {
    val RequestsCounter = scopedStats.scope("getMembers").counter("requests")
    val SuccessCounter = scopedStats.scope("getMembers").counter("success")
    val FailuresCounter = scopedStats.scope("getMembers").counter("failures")
    val FailuresScope = scopedStats.scope("getMembers").scope("failures")
  }
  
  
  def getMembers(): Future[GetMembersResponseST] = {
    __stats_getMembers.RequestsCounter.incr()
    this.service(encodeRequest("getMembers", getMembers$args())) flatMap { response =>
      val result = decodeResponse(response, getMembers$result)
      val exception =
        None
      exception.orElse(result.success.map(Future.value)).getOrElse(Future.exception(missingResult("getMembers")))
    } rescue {
      case ex: SourcedException => {
        if (this.serviceName != "") { ex.serviceName = this.serviceName }
        Future.exception(ex)
      }
    } onSuccess { _ =>
      __stats_getMembers.SuccessCounter.incr()
    } onFailure { ex =>
      __stats_getMembers.FailuresCounter.incr()
      __stats_getMembers.FailuresScope.counter(ex.getClass.getName).incr()
    }
  }
}